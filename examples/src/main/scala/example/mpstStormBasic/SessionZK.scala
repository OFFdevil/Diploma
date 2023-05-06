package example.mpstStormBasic

import event_lang.dsl._
import example.mpstStormBasic.types.SesCMPaperTypes.M.{EPType_M, PSupervisor_m_M, __EPType_M}
import example.mpstStormBasic.types.SesCMPaperTypes.ZK.{EPType_ZK, Main_zk_ZK, __EPType_ZK}
import example.mpstStormBasic.types.SesCMPaperTypes.W.{EPType_W, __EPType_W}
import example.mpstStormBasic.types.SesCMPaperTypes.MESSAGES.Main._
import example.mpstStormBasic.types.SesCMPaperTypes.MESSAGES.PSupervisor._

case class StateZK(runApps: Set[Int] = Set()) extends TState

class SessionZK(val block: (AbstractChannelType, StateZK, AbstractChannelImp) => Boolean = (d, x, s) => false,
                val customCode: (AbstractChannelType, StateZK, AbstractChannelImp) => Unit = (d, x, s) => {}) extends EPType_ZK[StateZK] with AbstractEndPointTesting[__EPType_ZK, StateZK] {
  override def onStartUp: StateZK = StateZK()

  override val receive: Seq[HDL[StateZK]] = ELoop(
    λ_state(Main_zk_ZK.Failed_m_M, Main_zk_ZK.SndFailMtoM, Main_zk_ZK.SndFailMtoW) {
      case (s, c) =>
        println(s"[Zk] we should restart (not implemented): ${s.runApps.mkString(",")}")
        (s, c.failed_m_M() ! FailMtoM() ! FailMtoW())
    },
//    λ_state(PSupervisor_m_M.Failed_w_W, PSupervisor_m_M.SndFailSupervisorEnd) {
//      case (s, c) =>
//        println(s"[Supervisor] we should finish : ${s.runApps.mkString(",")}")
//        (s, c.failed_m_M() ! )
//    },
    λ_state(Main_zk_ZK.RcvNewSupervisor) {
      case (s, c) => c ? {
        case (m, c) =>
          (s.copy(runApps = s.runApps + m.appID), c)
      }
    },
    λ_state(Main_zk_ZK.RcvSupervisorDone) {
      case (s, c) => c ? {
        case (m, c) =>
          (s.copy(runApps = s.runApps - m.appID), c)
      }
    },
    λ_state(Main_zk_ZK.RcvEndCM) {
      case (s, c) => c ? {
        case (m, c) =>
          println(s"[zk] received $m - start termination")
          if (s.runApps.nonEmpty) {
            println(s"[zk] received $m however the following apps are still running ${s.runApps.mkString(",")}")
          }
          (s, c)
      }
    },

  )
}
