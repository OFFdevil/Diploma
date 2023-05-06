package example.mpstStormBasic

import event_lang.dsl._
import example.mpstStormBasic.types.SesCMPaperTypes.M.{EPType_M, __EPType_M}
import example.mpstStormBasic.types.SesCMPaperTypes.MESSAGES.Main._


case class StateM(appId: Int = 10) extends TState

class SessionMaster(val b1_max_pay: Int = 50,
                    val b2_max_pay: Int = 50,
                    val block: (AbstractChannelType, StateM, AbstractChannelImp) => Boolean = (d, x, s) => false,
                    val customCode: (AbstractChannelType, StateM, AbstractChannelImp) => Unit = (d, x, s) => {}) extends EPType_M[StateM] with AbstractEndPointTesting[__EPType_M, StateM] {
  override def onStartUp: StateM = StateM()


  import example.mpstStormBasic.types.SesCMPaperTypes.M.{Main_M => main_1, Main_m_M => main_2}

  override val receive: Seq[HDL[StateM]] = ELoop(
    //main
    λ_static(main_1.EPMain_M) {
      case c => c
    },
    λ(main_1.RcvFailMtoM) {
      case c => c.channelCon
    },
    λ(main_2.SndNewSupervisor) {
      case c => c ! NewSupervisor(100) // TODO: add int for supervisor
    },
    λ(main_2.SndSupervisorDone) {
      case c => c ! SupervisorDone(100) // TODO: add int for supervisor
    },
    λ(main_2.SndBMsg) {
      case c => c ! BMsg()
    },
    λ(main_2.SndPrepSpawn) {
      case c => c ! PrepSpawn()
    },
    λ(main_2.SndEndCM) {
      case c => c ! EndCM()
    },
    λ(main_2.SndTerminate) {
      case c => c ! Terminate()
    },
  )
}