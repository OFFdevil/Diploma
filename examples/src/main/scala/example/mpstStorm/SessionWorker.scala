package example.mpstStorm

import event_lang.dsl._
import example.mpstStorm.types.SesCMPaperTypes.W.{EPType_W, __EPType_W}
import example.mpstStorm.types.SesCMPaperTypes.ZK.{EPType_ZK, __EPType_ZK}

case class StateW(appId: Int = 10) extends TState

class SessionWorker(val b1_max_pay: Int = 50,
                        val b2_max_pay: Int = 50,
                        val block: (AbstractChannelType, StateW, AbstractChannelImp) => Boolean = (d, x, s) => false,
                        val customCode: (AbstractChannelType, StateW, AbstractChannelImp) => Unit = (d, x, s) => {}) extends EPType_W[StateW] with AbstractEndPointTesting[__EPType_W, StateW] {
  override def onStartUp: StateW = StateW()


  import example.two_buyer.TwoBuyer.Buyer.{Main_Buyer => main_B, Main_b1_Buyer => main_b1, TwoBuyer_b1_Buyer => twoB_b1, TwoBuyer_b2_Buyer => twoB_b2}

  override val receive: Seq[HDL[StateW]] = ELoop(
    //main

  )
}