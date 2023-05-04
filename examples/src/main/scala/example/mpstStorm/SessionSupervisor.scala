package example.mpstStorm

import event_lang.dsl._
import example.mpstStorm.types.SesCMPaperTypes.M.{EPType_M, __EPType_M}
import example.mpstStorm.types.SesCMPaperTypes.ZK.{EPType_ZK, Main_zk_ZK, __EPType_ZK}
import example.mpstStorm.types.SesCMPaperTypes.W.{EPType_W, __EPType_W}
import example.mpstStorm.types.SesCMPaperTypes.MESSAGES.PSupervisor._

case class StateS(appId: Int = 10) extends TState

class SessionSupervisor(val b1_max_pay: Int = 50,
                    val b2_max_pay: Int = 50,
                    val block: (AbstractChannelType, StateS, AbstractChannelImp) => Boolean = (d, x, s) => false,
                    val customCode: (AbstractChannelType, StateS, AbstractChannelImp) => Unit = (d, x, s) => {}) extends EPType_ZK[StateS] with AbstractEndPointTesting[__EPType_ZK, StateS] {
  override def onStartUp: StateS = StateS()


  import example.mpstStorm.types.SesCMPaperTypes.M.{PSupervisor_m_M => Supervisor}

  override val receive: Seq[HDL[StateS]] = ELoop(
    //supervisor
//    λ_static(Supervisor.SpawnPSupervisor) {
//      case c => c
//    },
//    λ_static() {
//      case c => c ! NewSupervisor(100) // TODO: add int for supervisor
//    },
    λ_static(Main_zk_ZK.SndFailMtoW)
    λ(Supervisor.SndLaunchSupervisor) {
      case c => c ! LaunchSupervisor(100) // TODO: add int for supervisor
    },
  )
}
