package example.mpstStormBasic.types

import event_lang._
import event_lang.dsl._
import event_lang.types.{MSG, RRole, Role, RoleSet}
/* ########################################## 
 * ###### GENERATED CODE - DO NOT EDIT ######
 * ##########################################
*/



object SesCMPaperTypes {
object RS {
val W : RoleSet = RoleSet("W")
val M : RoleSet = RoleSet("M")
val ZK : RoleSet = RoleSet("ZK")
}

object MESSAGES {
object PSupervisor {
case class LaunchSupervisor(appID:Int) extends MSG {
   override def l : String = "LaunchSupervisor"
}

case class FailSupervisorEnd(appId:Int) extends MSG {
   override def l : String = "FailSupervisorEnd"
}

}

object Main {
case class EndCM() extends MSG {
   override def l : String = "EndCM"
}

case class BMsg() extends MSG {
   override def l : String = "BMsg"
}

case class FailMtoM() extends MSG {
   override def l : String = "FailMtoM"
}

case class SupervisorDone(appID:Int) extends MSG {
   override def l : String = "SupervisorDone"
}

case class PrepSpawn() extends MSG {
   override def l : String = "PrepSpawn"
}

case class FailMtoW() extends MSG {
   override def l : String = "FailMtoW"
}

case class NewSupervisor(appID:Int) extends MSG {
   override def l : String = "NewSupervisor"
}

case class Terminate() extends MSG {
   override def l : String = "Terminate"
}

}

}

object PROTOCOLS {
object Main {
val m_M = Role("m",RoleSet("M"))
val M = RoleSet("M")
val W = RoleSet("W")
val zk_ZK = Role("zk",RoleSet("ZK"))
}

object PSupervisor {
val w_W = Role("w",RoleSet("W"))
val W = RoleSet("W")
val m_M = Role("m",RoleSet("M"))
}

}

object W {
val subs : Seq[dsl.ChannelTypeSubS] = List(PSupervisor_w_W.EPPSupervisor_w_W,PSupervisor_W.EPPSupervisor_W,Main_W.EPMain_W)
trait __EPType_W extends AbstractChannelType {

}

trait EPType_W[T<: TState] extends AbstractEndPoint[__EPType_W,T] {
override val roleSet: RoleSet = RoleSet("W")
  override val subs : Seq[dsl.ChannelTypeSubS] = List(PSupervisor_w_W.EPPSupervisor_w_W,PSupervisor_W.EPPSupervisor_W,Main_W.EPMain_W)

}

object PSupervisor_w_W{
trait EPPSupervisor_w_W extends __EPType_W

object EPPSupervisor_w_W extends EPPSupervisor_w_W with event_lang.dsl.ChannelTypeSubS {
  override protected def __children: List[EPPSupervisor_w_W] = List(Hdl)
  override type implT = __EPPSupervisor_w_WImp 
  
  override def __create(c : AbstractChannel, session : Session) : implT = __EPPSupervisor_w_WImp(c,session) 
  override def body: AbstractChannelType = children.head
  override def argsC: List[Role] = List(Role("m",RoleSet("M"))) 
  override def argsP: Role = Role("w",RoleSet("W")) 
  override def argsRs: List[RoleSet] = List(RoleSet("W")) 
  override def prjTo : RRole = Role("w",RoleSet("W")) 
  override def rootRole: Role = Role("m",RoleSet("M")) 
  override def name : String = "PSupervisor"
}

protected case class __EPPSupervisor_w_WImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    EPPSupervisor_w_W
}
  
}


protected  trait Hdl extends EPPSupervisor_w_W with event_lang.dsl.ChannelTypeHdl
protected  object Hdl extends Hdl {
  override protected def __children: List[EPPSupervisor_w_W] = List(RcvLaunchSupervisor,End_w_W_PSupervisorFHandling)
  override type implT = __HdlImp
  override type implNextT = __RcvLaunchSupervisorImp
override def toString() : String = {"EPPSupervisor_w_W.Hdl"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __HdlImp(c,session)}

protected case class __HdlImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    Hdl
}
  
}


  trait RcvLaunchSupervisor extends EPPSupervisor_w_W with event_lang.dsl.ChannelTypeRcv
  object RcvLaunchSupervisor extends RcvLaunchSupervisor {
  override protected def __children: List[EPPSupervisor_w_W] = List(End_w_W_PSupervisor)
  override type implT = __RcvLaunchSupervisorImp
  override type implNextT = __End_w_W_PSupervisorImp
override def toString() : String = {"EPPSupervisor_w_W.RcvLaunchSupervisor"}
  override type msgT = MESSAGES.PSupervisor.LaunchSupervisor
   override def frm : Role = Role("m",RoleSet("M")) 
   override def l : String = "LaunchSupervisor"
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RcvLaunchSupervisorImp(c,session)}

protected case class __RcvLaunchSupervisorImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RcvLaunchSupervisor
}
  def rcvFrmm_M : (MESSAGES.PSupervisor.LaunchSupervisor,__End_w_W_PSupervisorImp) = {(c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.PSupervisor.LaunchSupervisor],__End_w_W_PSupervisorImp(c,session))}
def ?[T](f : PartialFunction[(MESSAGES.PSupervisor.LaunchSupervisor,__End_w_W_PSupervisorImp),T]) : T = {
  f((c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.PSupervisor.LaunchSupervisor],__End_w_W_PSupervisorImp(c,session))) 
}
def rcvMSG : MESSAGES.PSupervisor.LaunchSupervisor = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.PSupervisor.LaunchSupervisor]}
def ? : MESSAGES.PSupervisor.LaunchSupervisor = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.PSupervisor.LaunchSupervisor]}
def channelCon : __End_w_W_PSupervisorImp = {__End_w_W_PSupervisorImp(c,session)}

}


protected  trait End_w_W_PSupervisor extends EPPSupervisor_w_W with event_lang.dsl.ChannelTypeEnd
protected  object End_w_W_PSupervisor extends End_w_W_PSupervisor {
  override protected def __children: List[EPPSupervisor_w_W] = List()
  override type implT = __End_w_W_PSupervisorImp
  override type implNextT = Nothing
override def toString() : String = {"EPPSupervisor_w_W.End_w_W_PSupervisor"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_w_W_PSupervisorImp(c,session)}

protected case class __End_w_W_PSupervisorImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_w_W_PSupervisor
}
  
}



protected  trait End_w_W_PSupervisorFHandling extends EPPSupervisor_w_W with event_lang.dsl.ChannelTypeEnd
protected  object End_w_W_PSupervisorFHandling extends End_w_W_PSupervisorFHandling {
  override protected def __children: List[EPPSupervisor_w_W] = List()
  override type implT = __End_w_W_PSupervisorFHandlingImp
  override type implNextT = Nothing
override def toString() : String = {"EPPSupervisor_w_W.End_w_W_PSupervisorFHandling"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_w_W_PSupervisorFHandlingImp(c,session)}

protected case class __End_w_W_PSupervisorFHandlingImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_w_W_PSupervisorFHandling
}
  
}


}

object PSupervisor_W{
trait EPPSupervisor_W extends __EPType_W

object EPPSupervisor_W extends EPPSupervisor_W with event_lang.dsl.ChannelTypeSubS {
  override protected def __children: List[EPPSupervisor_W] = List(Hdl)
  override type implT = __EPPSupervisor_WImp 
  
  override def __create(c : AbstractChannel, session : Session) : implT = __EPPSupervisor_WImp(c,session) 
  override def body: AbstractChannelType = children.head
  override def argsC: List[Role] = List(Role("m",RoleSet("M"))) 
  override def argsP: Role = Role("w",RoleSet("W")) 
  override def argsRs: List[RoleSet] = List(RoleSet("W")) 
  override def prjTo : RRole = RoleSet("W") 
  override def rootRole: Role = Role("m",RoleSet("M")) 
  override def name : String = "PSupervisor"
}

protected case class __EPPSupervisor_WImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    EPPSupervisor_W
}
  
}


protected  trait Hdl extends EPPSupervisor_W with event_lang.dsl.ChannelTypeHdl
protected  object Hdl extends Hdl {
  override protected def __children: List[EPPSupervisor_W] = List(End_W_PSupervisor,RcvFailSupervisorEnd)
  override type implT = __HdlImp
  override type implNextT = __End_W_PSupervisorImp
override def toString() : String = {"EPPSupervisor_W.Hdl"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __HdlImp(c,session)}

protected case class __HdlImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    Hdl
}
  
}


protected  trait End_W_PSupervisor extends EPPSupervisor_W with event_lang.dsl.ChannelTypeEnd
protected  object End_W_PSupervisor extends End_W_PSupervisor {
  override protected def __children: List[EPPSupervisor_W] = List()
  override type implT = __End_W_PSupervisorImp
  override type implNextT = Nothing
override def toString() : String = {"EPPSupervisor_W.End_W_PSupervisor"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_W_PSupervisorImp(c,session)}

protected case class __End_W_PSupervisorImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_W_PSupervisor
}
  
}



  trait RcvFailSupervisorEnd extends EPPSupervisor_W with event_lang.dsl.ChannelTypeRcv
  object RcvFailSupervisorEnd extends RcvFailSupervisorEnd {
  override protected def __children: List[EPPSupervisor_W] = List(End_W_PSupervisorFHandling)
  override type implT = __RcvFailSupervisorEndImp
  override type implNextT = __End_W_PSupervisorFHandlingImp
override def toString() : String = {"EPPSupervisor_W.RcvFailSupervisorEnd"}
  override type msgT = MESSAGES.PSupervisor.FailSupervisorEnd
   override def frm : Role = Role("m",RoleSet("M")) 
   override def l : String = "FailSupervisorEnd"
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RcvFailSupervisorEndImp(c,session)}

protected case class __RcvFailSupervisorEndImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RcvFailSupervisorEnd
}
  def rcvFrmm_M : (MESSAGES.PSupervisor.FailSupervisorEnd,__End_W_PSupervisorFHandlingImp) = {(c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.PSupervisor.FailSupervisorEnd],__End_W_PSupervisorFHandlingImp(c,session))}
def ?[T](f : PartialFunction[(MESSAGES.PSupervisor.FailSupervisorEnd,__End_W_PSupervisorFHandlingImp),T]) : T = {
  f((c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.PSupervisor.FailSupervisorEnd],__End_W_PSupervisorFHandlingImp(c,session))) 
}
def rcvMSG : MESSAGES.PSupervisor.FailSupervisorEnd = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.PSupervisor.FailSupervisorEnd]}
def ? : MESSAGES.PSupervisor.FailSupervisorEnd = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.PSupervisor.FailSupervisorEnd]}
def channelCon : __End_W_PSupervisorFHandlingImp = {__End_W_PSupervisorFHandlingImp(c,session)}

}


protected  trait End_W_PSupervisorFHandling extends EPPSupervisor_W with event_lang.dsl.ChannelTypeEnd
protected  object End_W_PSupervisorFHandling extends End_W_PSupervisorFHandling {
  override protected def __children: List[EPPSupervisor_W] = List()
  override type implT = __End_W_PSupervisorFHandlingImp
  override type implNextT = Nothing
override def toString() : String = {"EPPSupervisor_W.End_W_PSupervisorFHandling"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_W_PSupervisorFHandlingImp(c,session)}

protected case class __End_W_PSupervisorFHandlingImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_W_PSupervisorFHandling
}
  
}


}

object Main_W{
trait EPMain_W extends __EPType_W

object EPMain_W extends EPMain_W with event_lang.dsl.ChannelTypeSubS {
  override protected def __children: List[EPMain_W] = List(Hdl)
  override type implT = __EPMain_WImp 
  
  override def __create(c : AbstractChannel, session : Session) : implT = __EPMain_WImp(c,session) 
  override def body: AbstractChannelType = children.head
  override def argsC: List[Role] = List(Role("zk",RoleSet("ZK"))) 
  override def argsP: Role = Role("m",RoleSet("M")) 
  override def argsRs: List[RoleSet] = List(RoleSet("M"), RoleSet("W")) 
  override def prjTo : RRole = RoleSet("W") 
  override def rootRole: Role = Role("zk",RoleSet("ZK")) 
  override def name : String = "Main"
}

protected case class __EPMain_WImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    EPMain_W
}
  
}


protected  trait Hdl extends EPMain_W with event_lang.dsl.ChannelTypeHdl
protected  object Hdl extends Hdl {
  override protected def __children: List[EPMain_W] = List(RecT,RcvFailMtoW)
  override type implT = __HdlImp
  override type implNextT = __RecTImp
override def toString() : String = {"EPMain_W.Hdl"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __HdlImp(c,session)}

protected case class __HdlImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    Hdl
}
  
}


protected  trait RecT extends EPMain_W with event_lang.dsl.ChannelTypeRec
protected  object RecT extends RecT {
  override protected def __children: List[EPMain_W] = List(Merge_PrepSpawn_BMsg_Terminate)
  override type implT = __RecTImp
  override type implNextT = __Merge_PrepSpawn_BMsg_TerminateImp
override def toString() : String = {"EPMain_W.RecT"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RecTImp(c,session)}

protected case class __RecTImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RecT
}
  
}


protected  trait Merge_PrepSpawn_BMsg_Terminate extends EPMain_W with event_lang.dsl.ChannelTypeMerge
protected  object Merge_PrepSpawn_BMsg_Terminate extends Merge_PrepSpawn_BMsg_Terminate {
  override protected def __children: List[EPMain_W] = List(RcvPrepSpawn,RcvBMsg,RcvTerminate)
  override type implT = __Merge_PrepSpawn_BMsg_TerminateImp
  override type implNextT = __RcvPrepSpawnImp
override def toString() : String = {"EPMain_W.Merge_PrepSpawn_BMsg_Terminate"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __Merge_PrepSpawn_BMsg_TerminateImp(c,session)}

protected case class __Merge_PrepSpawn_BMsg_TerminateImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    Merge_PrepSpawn_BMsg_Terminate
}
  
}


  trait RcvPrepSpawn extends EPMain_W with event_lang.dsl.ChannelTypeRcv
  object RcvPrepSpawn extends RcvPrepSpawn {
  override protected def __children: List[EPMain_W] = List(SpawnPSupervisor)
  override type implT = __RcvPrepSpawnImp
  override type implNextT = __SpawnPSupervisorImp
override def toString() : String = {"EPMain_W.RcvPrepSpawn"}
  override type msgT = MESSAGES.Main.PrepSpawn
   override def frm : Role = Role("m",RoleSet("M")) 
   override def l : String = "PrepSpawn"
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RcvPrepSpawnImp(c,session)}

protected case class __RcvPrepSpawnImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RcvPrepSpawn
}
  def rcvFrmm_M : (MESSAGES.Main.PrepSpawn,__SpawnPSupervisorImp) = {(c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.PrepSpawn],__SpawnPSupervisorImp(c,session))}
def ?[T](f : PartialFunction[(MESSAGES.Main.PrepSpawn,__SpawnPSupervisorImp),T]) : T = {
  f((c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.PrepSpawn],__SpawnPSupervisorImp(c,session))) 
}
def rcvMSG : MESSAGES.Main.PrepSpawn = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.PrepSpawn]}
def ? : MESSAGES.Main.PrepSpawn = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.PrepSpawn]}
def channelCon : __SpawnPSupervisorImp = {__SpawnPSupervisorImp(c,session)}

}


  trait SpawnPSupervisor extends EPMain_W with event_lang.dsl.ChannelTypeSpawn
  object SpawnPSupervisor extends SpawnPSupervisor {
  override protected def __children: List[EPMain_W] = List(T)
  override type implT = __SpawnPSupervisorImp
  override type implNextT = __TImp
override def toString() : String = {"EPMain_W.SpawnPSupervisor"}
    override def y: List[Role] = List(Role("m",RoleSet("M"))) 
  override def pickR: RoleSet = RoleSet("W") 
  override def rs: List[RoleSet] = List(RoleSet("W")) 
  override def name: String = "PSupervisor" 
  override def subC(r : RRole) : event_lang.dsl.ChannelTypeSubS = {  null   }
  override protected def __create(c : AbstractChannel, session : Session) : implT = __SpawnPSupervisorImp(c,session)}

protected case class __SpawnPSupervisorImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SpawnPSupervisor
}
  // SPAWN is handled internally -- i.e. no use code here
}


protected  trait T extends EPMain_W with event_lang.dsl.ChannelTypeT
protected  object T extends T {
  override protected def __children: List[EPMain_W] = List(RecT)
  override type implT = __TImp
  override type implNextT = __RecTImp
override def toString() : String = {"EPMain_W.T"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __TImp(c,session)}

protected case class __TImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    T
}
  
}



  trait RcvBMsg extends EPMain_W with event_lang.dsl.ChannelTypeRcv
  object RcvBMsg extends RcvBMsg {
  override protected def __children: List[EPMain_W] = List(T)
  override type implT = __RcvBMsgImp
  override type implNextT = __TImp
override def toString() : String = {"EPMain_W.RcvBMsg"}
  override type msgT = MESSAGES.Main.BMsg
   override def frm : Role = Role("m",RoleSet("M")) 
   override def l : String = "BMsg"
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RcvBMsgImp(c,session)}

protected case class __RcvBMsgImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RcvBMsg
}
  def rcvFrmm_M : (MESSAGES.Main.BMsg,__TImp) = {(c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.BMsg],__TImp(c,session))}
def ?[T](f : PartialFunction[(MESSAGES.Main.BMsg,__TImp),T]) : T = {
  f((c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.BMsg],__TImp(c,session))) 
}
def rcvMSG : MESSAGES.Main.BMsg = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.BMsg]}
def ? : MESSAGES.Main.BMsg = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.BMsg]}
def channelCon : __TImp = {__TImp(c,session)}

}

//there was an occurens of t already

  trait RcvTerminate extends EPMain_W with event_lang.dsl.ChannelTypeRcv
  object RcvTerminate extends RcvTerminate {
  override protected def __children: List[EPMain_W] = List(End_W_MainTerminate)
  override type implT = __RcvTerminateImp
  override type implNextT = __End_W_MainTerminateImp
override def toString() : String = {"EPMain_W.RcvTerminate"}
  override type msgT = MESSAGES.Main.Terminate
   override def frm : Role = Role("m",RoleSet("M")) 
   override def l : String = "Terminate"
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RcvTerminateImp(c,session)}

protected case class __RcvTerminateImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RcvTerminate
}
  def rcvFrmm_M : (MESSAGES.Main.Terminate,__End_W_MainTerminateImp) = {(c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.Terminate],__End_W_MainTerminateImp(c,session))}
def ?[T](f : PartialFunction[(MESSAGES.Main.Terminate,__End_W_MainTerminateImp),T]) : T = {
  f((c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.Terminate],__End_W_MainTerminateImp(c,session))) 
}
def rcvMSG : MESSAGES.Main.Terminate = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.Terminate]}
def ? : MESSAGES.Main.Terminate = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.Terminate]}
def channelCon : __End_W_MainTerminateImp = {__End_W_MainTerminateImp(c,session)}

}


protected  trait End_W_MainTerminate extends EPMain_W with event_lang.dsl.ChannelTypeEnd
protected  object End_W_MainTerminate extends End_W_MainTerminate {
  override protected def __children: List[EPMain_W] = List()
  override type implT = __End_W_MainTerminateImp
  override type implNextT = Nothing
override def toString() : String = {"EPMain_W.End_W_MainTerminate"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_W_MainTerminateImp(c,session)}

protected case class __End_W_MainTerminateImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_W_MainTerminate
}
  
}



  trait RcvFailMtoW extends EPMain_W with event_lang.dsl.ChannelTypeRcv
  object RcvFailMtoW extends RcvFailMtoW {
  override protected def __children: List[EPMain_W] = List(End_W_MainFHandling)
  override type implT = __RcvFailMtoWImp
  override type implNextT = __End_W_MainFHandlingImp
override def toString() : String = {"EPMain_W.RcvFailMtoW"}
  override type msgT = MESSAGES.Main.FailMtoW
   override def frm : Role = Role("zk",RoleSet("ZK")) 
   override def l : String = "FailMtoW"
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RcvFailMtoWImp(c,session)}

protected case class __RcvFailMtoWImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RcvFailMtoW
}
  def rcvFrmzk_ZK : (MESSAGES.Main.FailMtoW,__End_W_MainFHandlingImp) = {(c.rcv(Role("zk",RoleSet("ZK"))).asInstanceOf[MESSAGES.Main.FailMtoW],__End_W_MainFHandlingImp(c,session))}
def ?[T](f : PartialFunction[(MESSAGES.Main.FailMtoW,__End_W_MainFHandlingImp),T]) : T = {
  f((c.rcv(Role("zk",RoleSet("ZK"))).asInstanceOf[MESSAGES.Main.FailMtoW],__End_W_MainFHandlingImp(c,session))) 
}
def rcvMSG : MESSAGES.Main.FailMtoW = {c.rcv(Role("zk",RoleSet("ZK"))).asInstanceOf[MESSAGES.Main.FailMtoW]}
def ? : MESSAGES.Main.FailMtoW = {c.rcv(Role("zk",RoleSet("ZK"))).asInstanceOf[MESSAGES.Main.FailMtoW]}
def channelCon : __End_W_MainFHandlingImp = {__End_W_MainFHandlingImp(c,session)}

}


protected  trait End_W_MainFHandling extends EPMain_W with event_lang.dsl.ChannelTypeEnd
protected  object End_W_MainFHandling extends End_W_MainFHandling {
  override protected def __children: List[EPMain_W] = List()
  override type implT = __End_W_MainFHandlingImp
  override type implNextT = Nothing
override def toString() : String = {"EPMain_W.End_W_MainFHandling"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_W_MainFHandlingImp(c,session)}

protected case class __End_W_MainFHandlingImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_W_MainFHandling
}
  
}


}

}

object M {
val subs : Seq[dsl.ChannelTypeSubS] = List(PSupervisor_m_M.EPPSupervisor_m_M,Main_m_M.EPMain_m_M,Main_M.EPMain_M)
trait __EPType_M extends AbstractChannelType {

}

trait EPType_M[T<: TState] extends AbstractEndPoint[__EPType_M,T] {
override val roleSet: RoleSet = RoleSet("M")
  override val subs : Seq[dsl.ChannelTypeSubS] = List(PSupervisor_m_M.EPPSupervisor_m_M,Main_m_M.EPMain_m_M,Main_M.EPMain_M)

}

object PSupervisor_m_M{
trait EPPSupervisor_m_M extends __EPType_M

object EPPSupervisor_m_M extends EPPSupervisor_m_M with event_lang.dsl.ChannelTypeSubS {
  override protected def __children: List[EPPSupervisor_m_M] = List(Hdl)
  override type implT = __EPPSupervisor_m_MImp 
  
  override def __create(c : AbstractChannel, session : Session) : implT = __EPPSupervisor_m_MImp(c,session) 
  override def body: AbstractChannelType = children.head
  override def argsC: List[Role] = List(Role("m",RoleSet("M"))) 
  override def argsP: Role = Role("w",RoleSet("W")) 
  override def argsRs: List[RoleSet] = List(RoleSet("W")) 
  override def prjTo : RRole = Role("m",RoleSet("M")) 
  override def rootRole: Role = Role("m",RoleSet("M")) 
  override def name : String = "PSupervisor"
}

protected case class __EPPSupervisor_m_MImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    EPPSupervisor_m_M
}
  
}


protected  trait Hdl extends EPPSupervisor_m_M with event_lang.dsl.ChannelTypeHdl
protected  object Hdl extends Hdl {
  override protected def __children: List[EPPSupervisor_m_M] = List(SndLaunchSupervisor,Failed_w_W)
  override type implT = __HdlImp
  override type implNextT = __SndLaunchSupervisorImp
override def toString() : String = {"EPPSupervisor_m_M.Hdl"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __HdlImp(c,session)}

protected case class __HdlImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    Hdl
}
  
}


  trait SndLaunchSupervisor extends EPPSupervisor_m_M with event_lang.dsl.ChannelTypeSnd
  object SndLaunchSupervisor extends SndLaunchSupervisor {
  override protected def __children: List[EPPSupervisor_m_M] = List(End_m_M_PSupervisor)
  override type implT = __SndLaunchSupervisorImp
  override type implNextT = __End_m_M_PSupervisorImp
override def toString() : String = {"EPPSupervisor_m_M.SndLaunchSupervisor"}
    override def to : RRole = Role("w",RoleSet("W")) 
   override def l : String = "LaunchSupervisor" 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __SndLaunchSupervisorImp(c,session)}

protected case class __SndLaunchSupervisorImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SndLaunchSupervisor
}
  private var notUsed = true
def sndTow_W(m : MESSAGES.PSupervisor.LaunchSupervisor) : __End_m_M_PSupervisorImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("w",RoleSet("W")),m)
__End_m_M_PSupervisorImp(c,session)}
def !(m : MESSAGES.PSupervisor.LaunchSupervisor) : __End_m_M_PSupervisorImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("w",RoleSet("W")),m)
__End_m_M_PSupervisorImp(c,session)}
def snd(m : MESSAGES.PSupervisor.LaunchSupervisor) : __End_m_M_PSupervisorImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("w",RoleSet("W")),m)
__End_m_M_PSupervisorImp(c,session)}

}


protected  trait End_m_M_PSupervisor extends EPPSupervisor_m_M with event_lang.dsl.ChannelTypeEnd
protected  object End_m_M_PSupervisor extends End_m_M_PSupervisor {
  override protected def __children: List[EPPSupervisor_m_M] = List()
  override type implT = __End_m_M_PSupervisorImp
  override type implNextT = Nothing
override def toString() : String = {"EPPSupervisor_m_M.End_m_M_PSupervisor"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_m_M_PSupervisorImp(c,session)}

protected case class __End_m_M_PSupervisorImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_m_M_PSupervisor
}
  
}



  trait Failed_w_W extends EPPSupervisor_m_M with event_lang.dsl.ChannelTypeFDtct
  object Failed_w_W extends Failed_w_W {
  override protected def __children: List[EPPSupervisor_m_M] = List(SndFailSupervisorEnd)
  override type implT = __Failed_w_WImp
  override type implNextT = __SndFailSupervisorEndImp
override def toString() : String = {"EPPSupervisor_m_M.Failed_w_W"}
  override def suspect : Role = Role("w",RoleSet("W")) 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __Failed_w_WImp(c,session)}

protected case class __Failed_w_WImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    Failed_w_W
}
  def failed_w_W(): __SndFailSupervisorEndImp = {__SndFailSupervisorEndImp(c,session)}

}


  trait SndFailSupervisorEnd extends EPPSupervisor_m_M with event_lang.dsl.ChannelTypeSnd
  object SndFailSupervisorEnd extends SndFailSupervisorEnd {
  override protected def __children: List[EPPSupervisor_m_M] = List(End_m_M_PSupervisorFHandling)
  override type implT = __SndFailSupervisorEndImp
  override type implNextT = __End_m_M_PSupervisorFHandlingImp
override def toString() : String = {"EPPSupervisor_m_M.SndFailSupervisorEnd"}
    override def to : RRole = RoleSet("W") 
   override def l : String = "FailSupervisorEnd" 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __SndFailSupervisorEndImp(c,session)}

protected case class __SndFailSupervisorEndImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SndFailSupervisorEnd
}
  private var notUsed = true
def sndToW(m : MESSAGES.PSupervisor.FailSupervisorEnd) : __End_m_M_PSupervisorFHandlingImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__End_m_M_PSupervisorFHandlingImp(c,session)}
def !(m : MESSAGES.PSupervisor.FailSupervisorEnd) : __End_m_M_PSupervisorFHandlingImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__End_m_M_PSupervisorFHandlingImp(c,session)}
def snd(m : MESSAGES.PSupervisor.FailSupervisorEnd) : __End_m_M_PSupervisorFHandlingImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__End_m_M_PSupervisorFHandlingImp(c,session)}

}


protected  trait End_m_M_PSupervisorFHandling extends EPPSupervisor_m_M with event_lang.dsl.ChannelTypeEnd
protected  object End_m_M_PSupervisorFHandling extends End_m_M_PSupervisorFHandling {
  override protected def __children: List[EPPSupervisor_m_M] = List()
  override type implT = __End_m_M_PSupervisorFHandlingImp
  override type implNextT = Nothing
override def toString() : String = {"EPPSupervisor_m_M.End_m_M_PSupervisorFHandling"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_m_M_PSupervisorFHandlingImp(c,session)}

protected case class __End_m_M_PSupervisorFHandlingImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_m_M_PSupervisorFHandling
}
  
}


}

object Main_m_M{
trait EPMain_m_M extends __EPType_M

object EPMain_m_M extends EPMain_m_M with event_lang.dsl.ChannelTypeSubS {
  override protected def __children: List[EPMain_m_M] = List(Hdl)
  override type implT = __EPMain_m_MImp 
  
  override def __create(c : AbstractChannel, session : Session) : implT = __EPMain_m_MImp(c,session) 
  override def body: AbstractChannelType = children.head
  override def argsC: List[Role] = List(Role("zk",RoleSet("ZK"))) 
  override def argsP: Role = Role("m",RoleSet("M")) 
  override def argsRs: List[RoleSet] = List(RoleSet("M"), RoleSet("W")) 
  override def prjTo : RRole = Role("m",RoleSet("M")) 
  override def rootRole: Role = Role("zk",RoleSet("ZK")) 
  override def name : String = "Main"
}

protected case class __EPMain_m_MImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    EPMain_m_M
}
  
}


protected  trait Hdl extends EPMain_m_M with event_lang.dsl.ChannelTypeHdl
protected  object Hdl extends Hdl {
  override protected def __children: List[EPMain_m_M] = List(RecT,End_m_M_MainFHandling)
  override type implT = __HdlImp
  override type implNextT = __RecTImp
override def toString() : String = {"EPMain_m_M.Hdl"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __HdlImp(c,session)}

protected case class __HdlImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    Hdl
}
  
}


protected  trait RecT extends EPMain_m_M with event_lang.dsl.ChannelTypeRec
protected  object RecT extends RecT {
  override protected def __children: List[EPMain_m_M] = List(SelNewSupervisorSupervisorDoneEndCM)
  override type implT = __RecTImp
  override type implNextT = __SelNewSupervisorSupervisorDoneEndCMImp
override def toString() : String = {"EPMain_m_M.RecT"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RecTImp(c,session)}

protected case class __RecTImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RecT
}
  
}


protected  trait SelNewSupervisorSupervisorDoneEndCM extends EPMain_m_M with event_lang.dsl.ChannelTypeSel
protected  object SelNewSupervisorSupervisorDoneEndCM extends SelNewSupervisorSupervisorDoneEndCM {
  override protected def __children: List[EPMain_m_M] = List(SndNewSupervisor,SndSupervisorDone,SndEndCM)
  override type implT = __SelNewSupervisorSupervisorDoneEndCMImp
  override type implNextT = __SndNewSupervisorImp
override def toString() : String = {"EPMain_m_M.SelNewSupervisorSupervisorDoneEndCM"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __SelNewSupervisorSupervisorDoneEndCMImp(c,session)}

protected case class __SelNewSupervisorSupervisorDoneEndCMImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SelNewSupervisorSupervisorDoneEndCM
}
  private var notUsed = true
def !(m : MESSAGES.Main.NewSupervisor) : __SndPrepSpawnImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
 __SndPrepSpawnImp(c,session)}
def sndTozk_ZK(m : MESSAGES.Main.NewSupervisor) : __SndPrepSpawnImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
 __SndPrepSpawnImp(c,session)}

def !(m : MESSAGES.Main.SupervisorDone) : __SndBMsgImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
 __SndBMsgImp(c,session)}
def sndTozk_ZK(m : MESSAGES.Main.SupervisorDone) : __SndBMsgImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
 __SndBMsgImp(c,session)}

def !(m : MESSAGES.Main.EndCM) : __SndTerminateImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
 __SndTerminateImp(c,session)}
def sndTozk_ZK(m : MESSAGES.Main.EndCM) : __SndTerminateImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
 __SndTerminateImp(c,session)}

}


  trait SndNewSupervisor extends EPMain_m_M with event_lang.dsl.ChannelTypeSnd
  object SndNewSupervisor extends SndNewSupervisor {
  override protected def __children: List[EPMain_m_M] = List(SndPrepSpawn)
  override type implT = __SndNewSupervisorImp
  override type implNextT = __SndPrepSpawnImp
override def toString() : String = {"EPMain_m_M.SndNewSupervisor"}
    override def to : RRole = Role("zk",RoleSet("ZK")) 
   override def l : String = "NewSupervisor" 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __SndNewSupervisorImp(c,session)}

protected case class __SndNewSupervisorImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SndNewSupervisor
}
  private var notUsed = true
def sndTozk_ZK(m : MESSAGES.Main.NewSupervisor) : __SndPrepSpawnImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
__SndPrepSpawnImp(c,session)}
def !(m : MESSAGES.Main.NewSupervisor) : __SndPrepSpawnImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
__SndPrepSpawnImp(c,session)}
def snd(m : MESSAGES.Main.NewSupervisor) : __SndPrepSpawnImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
__SndPrepSpawnImp(c,session)}

}


  trait SndPrepSpawn extends EPMain_m_M with event_lang.dsl.ChannelTypeSnd
  object SndPrepSpawn extends SndPrepSpawn {
  override protected def __children: List[EPMain_m_M] = List(SpawnPSupervisor)
  override type implT = __SndPrepSpawnImp
  override type implNextT = __SpawnPSupervisorImp
override def toString() : String = {"EPMain_m_M.SndPrepSpawn"}
    override def to : RRole = RoleSet("W") 
   override def l : String = "PrepSpawn" 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __SndPrepSpawnImp(c,session)}

protected case class __SndPrepSpawnImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SndPrepSpawn
}
  private var notUsed = true
def sndToW(m : MESSAGES.Main.PrepSpawn) : __SpawnPSupervisorImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__SpawnPSupervisorImp(c,session)}
def !(m : MESSAGES.Main.PrepSpawn) : __SpawnPSupervisorImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__SpawnPSupervisorImp(c,session)}
def snd(m : MESSAGES.Main.PrepSpawn) : __SpawnPSupervisorImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__SpawnPSupervisorImp(c,session)}

}


  trait SpawnPSupervisor extends EPMain_m_M with event_lang.dsl.ChannelTypeSpawn
  object SpawnPSupervisor extends SpawnPSupervisor {
  override protected def __children: List[EPMain_m_M] = List(T)
  override type implT = __SpawnPSupervisorImp
  override type implNextT = __TImp
override def toString() : String = {"EPMain_m_M.SpawnPSupervisor"}
    override def y: List[Role] = List(Role("m",RoleSet("M"))) 
  override def pickR: RoleSet = RoleSet("W") 
  override def rs: List[RoleSet] = List(RoleSet("W")) 
  override def name: String = "PSupervisor" 
  override def subC(r : RRole) : event_lang.dsl.ChannelTypeSubS = {  null   }
  override protected def __create(c : AbstractChannel, session : Session) : implT = __SpawnPSupervisorImp(c,session)}

protected case class __SpawnPSupervisorImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SpawnPSupervisor
}
  // SPAWN is handled internally -- i.e. no use code here
}


protected  trait T extends EPMain_m_M with event_lang.dsl.ChannelTypeT
protected  object T extends T {
  override protected def __children: List[EPMain_m_M] = List(RecT)
  override type implT = __TImp
  override type implNextT = __RecTImp
override def toString() : String = {"EPMain_m_M.T"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __TImp(c,session)}

protected case class __TImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    T
}
  
}



  trait SndSupervisorDone extends EPMain_m_M with event_lang.dsl.ChannelTypeSnd
  object SndSupervisorDone extends SndSupervisorDone {
  override protected def __children: List[EPMain_m_M] = List(SndBMsg)
  override type implT = __SndSupervisorDoneImp
  override type implNextT = __SndBMsgImp
override def toString() : String = {"EPMain_m_M.SndSupervisorDone"}
    override def to : RRole = Role("zk",RoleSet("ZK")) 
   override def l : String = "SupervisorDone" 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __SndSupervisorDoneImp(c,session)}

protected case class __SndSupervisorDoneImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SndSupervisorDone
}
  private var notUsed = true
def sndTozk_ZK(m : MESSAGES.Main.SupervisorDone) : __SndBMsgImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
__SndBMsgImp(c,session)}
def !(m : MESSAGES.Main.SupervisorDone) : __SndBMsgImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
__SndBMsgImp(c,session)}
def snd(m : MESSAGES.Main.SupervisorDone) : __SndBMsgImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
__SndBMsgImp(c,session)}

}


  trait SndBMsg extends EPMain_m_M with event_lang.dsl.ChannelTypeSnd
  object SndBMsg extends SndBMsg {
  override protected def __children: List[EPMain_m_M] = List(T)
  override type implT = __SndBMsgImp
  override type implNextT = __TImp
override def toString() : String = {"EPMain_m_M.SndBMsg"}
    override def to : RRole = RoleSet("W") 
   override def l : String = "BMsg" 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __SndBMsgImp(c,session)}

protected case class __SndBMsgImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SndBMsg
}
  private var notUsed = true
def sndToW(m : MESSAGES.Main.BMsg) : __TImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__TImp(c,session)}
def !(m : MESSAGES.Main.BMsg) : __TImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__TImp(c,session)}
def snd(m : MESSAGES.Main.BMsg) : __TImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__TImp(c,session)}

}

//there was an occurens of t already

  trait SndEndCM extends EPMain_m_M with event_lang.dsl.ChannelTypeSnd
  object SndEndCM extends SndEndCM {
  override protected def __children: List[EPMain_m_M] = List(SndTerminate)
  override type implT = __SndEndCMImp
  override type implNextT = __SndTerminateImp
override def toString() : String = {"EPMain_m_M.SndEndCM"}
    override def to : RRole = Role("zk",RoleSet("ZK")) 
   override def l : String = "EndCM" 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __SndEndCMImp(c,session)}

protected case class __SndEndCMImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SndEndCM
}
  private var notUsed = true
def sndTozk_ZK(m : MESSAGES.Main.EndCM) : __SndTerminateImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
__SndTerminateImp(c,session)}
def !(m : MESSAGES.Main.EndCM) : __SndTerminateImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
__SndTerminateImp(c,session)}
def snd(m : MESSAGES.Main.EndCM) : __SndTerminateImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(Role("zk",RoleSet("ZK")),m)
__SndTerminateImp(c,session)}

}


  trait SndTerminate extends EPMain_m_M with event_lang.dsl.ChannelTypeSnd
  object SndTerminate extends SndTerminate {
  override protected def __children: List[EPMain_m_M] = List(End_m_M_MainEndCM)
  override type implT = __SndTerminateImp
  override type implNextT = __End_m_M_MainEndCMImp
override def toString() : String = {"EPMain_m_M.SndTerminate"}
    override def to : RRole = RoleSet("W") 
   override def l : String = "Terminate" 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __SndTerminateImp(c,session)}

protected case class __SndTerminateImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SndTerminate
}
  private var notUsed = true
def sndToW(m : MESSAGES.Main.Terminate) : __End_m_M_MainEndCMImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__End_m_M_MainEndCMImp(c,session)}
def !(m : MESSAGES.Main.Terminate) : __End_m_M_MainEndCMImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__End_m_M_MainEndCMImp(c,session)}
def snd(m : MESSAGES.Main.Terminate) : __End_m_M_MainEndCMImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__End_m_M_MainEndCMImp(c,session)}

}


protected  trait End_m_M_MainEndCM extends EPMain_m_M with event_lang.dsl.ChannelTypeEnd
protected  object End_m_M_MainEndCM extends End_m_M_MainEndCM {
  override protected def __children: List[EPMain_m_M] = List()
  override type implT = __End_m_M_MainEndCMImp
  override type implNextT = Nothing
override def toString() : String = {"EPMain_m_M.End_m_M_MainEndCM"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_m_M_MainEndCMImp(c,session)}

protected case class __End_m_M_MainEndCMImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_m_M_MainEndCM
}
  
}



protected  trait End_m_M_MainFHandling extends EPMain_m_M with event_lang.dsl.ChannelTypeEnd
protected  object End_m_M_MainFHandling extends End_m_M_MainFHandling {
  override protected def __children: List[EPMain_m_M] = List()
  override type implT = __End_m_M_MainFHandlingImp
  override type implNextT = Nothing
override def toString() : String = {"EPMain_m_M.End_m_M_MainFHandling"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_m_M_MainFHandlingImp(c,session)}

protected case class __End_m_M_MainFHandlingImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_m_M_MainFHandling
}
  
}


}

object Main_M{
trait EPMain_M extends __EPType_M

object EPMain_M extends EPMain_M with event_lang.dsl.ChannelTypeSubS {
  override protected def __children: List[EPMain_M] = List(Hdl)
  override type implT = __EPMain_MImp 
  
  override def __create(c : AbstractChannel, session : Session) : implT = __EPMain_MImp(c,session) 
  override def body: AbstractChannelType = children.head
  override def argsC: List[Role] = List(Role("zk",RoleSet("ZK"))) 
  override def argsP: Role = Role("m",RoleSet("M")) 
  override def argsRs: List[RoleSet] = List(RoleSet("M"), RoleSet("W")) 
  override def prjTo : RRole = RoleSet("M") 
  override def rootRole: Role = Role("zk",RoleSet("ZK")) 
  override def name : String = "Main"
}

protected case class __EPMain_MImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    EPMain_M
}
  
}


protected  trait Hdl extends EPMain_M with event_lang.dsl.ChannelTypeHdl
protected  object Hdl extends Hdl {
  override protected def __children: List[EPMain_M] = List(End_M_Main,RcvFailMtoM)
  override type implT = __HdlImp
  override type implNextT = __End_M_MainImp
override def toString() : String = {"EPMain_M.Hdl"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __HdlImp(c,session)}

protected case class __HdlImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    Hdl
}
  
}


protected  trait End_M_Main extends EPMain_M with event_lang.dsl.ChannelTypeEnd
protected  object End_M_Main extends End_M_Main {
  override protected def __children: List[EPMain_M] = List()
  override type implT = __End_M_MainImp
  override type implNextT = Nothing
override def toString() : String = {"EPMain_M.End_M_Main"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_M_MainImp(c,session)}

protected case class __End_M_MainImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_M_Main
}
  
}



  trait RcvFailMtoM extends EPMain_M with event_lang.dsl.ChannelTypeRcv
  object RcvFailMtoM extends RcvFailMtoM {
  override protected def __children: List[EPMain_M] = List(End_M_MainFHandling)
  override type implT = __RcvFailMtoMImp
  override type implNextT = __End_M_MainFHandlingImp
override def toString() : String = {"EPMain_M.RcvFailMtoM"}
  override type msgT = MESSAGES.Main.FailMtoM
   override def frm : Role = Role("zk",RoleSet("ZK")) 
   override def l : String = "FailMtoM"
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RcvFailMtoMImp(c,session)}

protected case class __RcvFailMtoMImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RcvFailMtoM
}
  def rcvFrmzk_ZK : (MESSAGES.Main.FailMtoM,__End_M_MainFHandlingImp) = {(c.rcv(Role("zk",RoleSet("ZK"))).asInstanceOf[MESSAGES.Main.FailMtoM],__End_M_MainFHandlingImp(c,session))}
def ?[T](f : PartialFunction[(MESSAGES.Main.FailMtoM,__End_M_MainFHandlingImp),T]) : T = {
  f((c.rcv(Role("zk",RoleSet("ZK"))).asInstanceOf[MESSAGES.Main.FailMtoM],__End_M_MainFHandlingImp(c,session))) 
}
def rcvMSG : MESSAGES.Main.FailMtoM = {c.rcv(Role("zk",RoleSet("ZK"))).asInstanceOf[MESSAGES.Main.FailMtoM]}
def ? : MESSAGES.Main.FailMtoM = {c.rcv(Role("zk",RoleSet("ZK"))).asInstanceOf[MESSAGES.Main.FailMtoM]}
def channelCon : __End_M_MainFHandlingImp = {__End_M_MainFHandlingImp(c,session)}

}


protected  trait End_M_MainFHandling extends EPMain_M with event_lang.dsl.ChannelTypeEnd
protected  object End_M_MainFHandling extends End_M_MainFHandling {
  override protected def __children: List[EPMain_M] = List()
  override type implT = __End_M_MainFHandlingImp
  override type implNextT = Nothing
override def toString() : String = {"EPMain_M.End_M_MainFHandling"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_M_MainFHandlingImp(c,session)}

protected case class __End_M_MainFHandlingImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_M_MainFHandling
}
  
}


}

}

object ZK {
val subs : Seq[dsl.ChannelTypeSubS] = List(Main_zk_ZK.EPMain_zk_ZK)
trait __EPType_ZK extends AbstractChannelType {

}

trait EPType_ZK[T<: TState] extends AbstractEndPoint[__EPType_ZK,T] {
override val roleSet: RoleSet = RoleSet("ZK")
  override val subs : Seq[dsl.ChannelTypeSubS] = List(Main_zk_ZK.EPMain_zk_ZK)

}

object Main_zk_ZK{
trait EPMain_zk_ZK extends __EPType_ZK

object EPMain_zk_ZK extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeSubS {
  override protected def __children: List[EPMain_zk_ZK] = List(Hdl)
  override type implT = __EPMain_zk_ZKImp 
  
  override def __create(c : AbstractChannel, session : Session) : implT = __EPMain_zk_ZKImp(c,session) 
  override def body: AbstractChannelType = children.head
  override def argsC: List[Role] = List(Role("zk",RoleSet("ZK"))) 
  override def argsP: Role = Role("m",RoleSet("M")) 
  override def argsRs: List[RoleSet] = List(RoleSet("M"), RoleSet("W")) 
  override def prjTo : RRole = Role("zk",RoleSet("ZK")) 
  override def rootRole: Role = Role("zk",RoleSet("ZK")) 
  override def name : String = "Main"
}

protected case class __EPMain_zk_ZKImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    EPMain_zk_ZK
}
  
}


protected  trait Hdl extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeHdl
protected  object Hdl extends Hdl {
  override protected def __children: List[EPMain_zk_ZK] = List(RecT,Failed_m_M)
  override type implT = __HdlImp
  override type implNextT = __RecTImp
override def toString() : String = {"EPMain_zk_ZK.Hdl"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __HdlImp(c,session)}

protected case class __HdlImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    Hdl
}
  
}


protected  trait RecT extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeRec
protected  object RecT extends RecT {
  override protected def __children: List[EPMain_zk_ZK] = List(SelNewSupervisorSupervisorDoneEndCM)
  override type implT = __RecTImp
  override type implNextT = __SelNewSupervisorSupervisorDoneEndCMImp
override def toString() : String = {"EPMain_zk_ZK.RecT"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RecTImp(c,session)}

protected case class __RecTImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RecT
}
  
}


protected  trait SelNewSupervisorSupervisorDoneEndCM extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeBrn
protected  object SelNewSupervisorSupervisorDoneEndCM extends SelNewSupervisorSupervisorDoneEndCM {
  override protected def __children: List[EPMain_zk_ZK] = List(RcvNewSupervisor,RcvSupervisorDone,RcvEndCM)
  override type implT = __SelNewSupervisorSupervisorDoneEndCMImp
  override type implNextT = __RcvNewSupervisorImp
override def toString() : String = {"EPMain_zk_ZK.SelNewSupervisorSupervisorDoneEndCM"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __SelNewSupervisorSupervisorDoneEndCMImp(c,session)}

protected case class __SelNewSupervisorSupervisorDoneEndCMImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SelNewSupervisorSupervisorDoneEndCM
}
  // Branching is only a valid return type not a valid input type
}


  trait RcvNewSupervisor extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeRcv
  object RcvNewSupervisor extends RcvNewSupervisor {
  override protected def __children: List[EPMain_zk_ZK] = List(T)
  override type implT = __RcvNewSupervisorImp
  override type implNextT = __TImp
override def toString() : String = {"EPMain_zk_ZK.RcvNewSupervisor"}
  override type msgT = MESSAGES.Main.NewSupervisor
   override def frm : Role = Role("m",RoleSet("M")) 
   override def l : String = "NewSupervisor"
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RcvNewSupervisorImp(c,session)}

protected case class __RcvNewSupervisorImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RcvNewSupervisor
}
  def rcvFrmm_M : (MESSAGES.Main.NewSupervisor,__TImp) = {(c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.NewSupervisor],__TImp(c,session))}
def ?[T](f : PartialFunction[(MESSAGES.Main.NewSupervisor,__TImp),T]) : T = {
  f((c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.NewSupervisor],__TImp(c,session))) 
}
def rcvMSG : MESSAGES.Main.NewSupervisor = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.NewSupervisor]}
def ? : MESSAGES.Main.NewSupervisor = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.NewSupervisor]}
def channelCon : __TImp = {__TImp(c,session)}

}


protected  trait T extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeT
protected  object T extends T {
  override protected def __children: List[EPMain_zk_ZK] = List(RecT)
  override type implT = __TImp
  override type implNextT = __RecTImp
override def toString() : String = {"EPMain_zk_ZK.T"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __TImp(c,session)}

protected case class __TImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    T
}
  
}



  trait RcvSupervisorDone extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeRcv
  object RcvSupervisorDone extends RcvSupervisorDone {
  override protected def __children: List[EPMain_zk_ZK] = List(T)
  override type implT = __RcvSupervisorDoneImp
  override type implNextT = __TImp
override def toString() : String = {"EPMain_zk_ZK.RcvSupervisorDone"}
  override type msgT = MESSAGES.Main.SupervisorDone
   override def frm : Role = Role("m",RoleSet("M")) 
   override def l : String = "SupervisorDone"
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RcvSupervisorDoneImp(c,session)}

protected case class __RcvSupervisorDoneImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RcvSupervisorDone
}
  def rcvFrmm_M : (MESSAGES.Main.SupervisorDone,__TImp) = {(c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.SupervisorDone],__TImp(c,session))}
def ?[T](f : PartialFunction[(MESSAGES.Main.SupervisorDone,__TImp),T]) : T = {
  f((c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.SupervisorDone],__TImp(c,session))) 
}
def rcvMSG : MESSAGES.Main.SupervisorDone = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.SupervisorDone]}
def ? : MESSAGES.Main.SupervisorDone = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.SupervisorDone]}
def channelCon : __TImp = {__TImp(c,session)}

}

//there was an occurens of t already

  trait RcvEndCM extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeRcv
  object RcvEndCM extends RcvEndCM {
  override protected def __children: List[EPMain_zk_ZK] = List(End_zk_ZK_MainEndCM)
  override type implT = __RcvEndCMImp
  override type implNextT = __End_zk_ZK_MainEndCMImp
override def toString() : String = {"EPMain_zk_ZK.RcvEndCM"}
  override type msgT = MESSAGES.Main.EndCM
   override def frm : Role = Role("m",RoleSet("M")) 
   override def l : String = "EndCM"
  override protected def __create(c : AbstractChannel, session : Session) : implT = __RcvEndCMImp(c,session)}

protected case class __RcvEndCMImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    RcvEndCM
}
  def rcvFrmm_M : (MESSAGES.Main.EndCM,__End_zk_ZK_MainEndCMImp) = {(c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.EndCM],__End_zk_ZK_MainEndCMImp(c,session))}
def ?[T](f : PartialFunction[(MESSAGES.Main.EndCM,__End_zk_ZK_MainEndCMImp),T]) : T = {
  f((c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.EndCM],__End_zk_ZK_MainEndCMImp(c,session))) 
}
def rcvMSG : MESSAGES.Main.EndCM = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.EndCM]}
def ? : MESSAGES.Main.EndCM = {c.rcv(Role("m",RoleSet("M"))).asInstanceOf[MESSAGES.Main.EndCM]}
def channelCon : __End_zk_ZK_MainEndCMImp = {__End_zk_ZK_MainEndCMImp(c,session)}

}


protected  trait End_zk_ZK_MainEndCM extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeEnd
protected  object End_zk_ZK_MainEndCM extends End_zk_ZK_MainEndCM {
  override protected def __children: List[EPMain_zk_ZK] = List()
  override type implT = __End_zk_ZK_MainEndCMImp
  override type implNextT = Nothing
override def toString() : String = {"EPMain_zk_ZK.End_zk_ZK_MainEndCM"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_zk_ZK_MainEndCMImp(c,session)}

protected case class __End_zk_ZK_MainEndCMImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_zk_ZK_MainEndCM
}
  
}



  trait Failed_m_M extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeFDtct
  object Failed_m_M extends Failed_m_M {
  override protected def __children: List[EPMain_zk_ZK] = List(SndFailMtoM)
  override type implT = __Failed_m_MImp
  override type implNextT = __SndFailMtoMImp
override def toString() : String = {"EPMain_zk_ZK.Failed_m_M"}
  override def suspect : Role = Role("m",RoleSet("M")) 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __Failed_m_MImp(c,session)}

protected case class __Failed_m_MImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    Failed_m_M
}
  def failed_m_M(): __SndFailMtoMImp = {__SndFailMtoMImp(c,session)}

}


  trait SndFailMtoM extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeSnd
  object SndFailMtoM extends SndFailMtoM {
  override protected def __children: List[EPMain_zk_ZK] = List(SndFailMtoW)
  override type implT = __SndFailMtoMImp
  override type implNextT = __SndFailMtoWImp
override def toString() : String = {"EPMain_zk_ZK.SndFailMtoM"}
    override def to : RRole = RoleSet("M") 
   override def l : String = "FailMtoM" 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __SndFailMtoMImp(c,session)}

protected case class __SndFailMtoMImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SndFailMtoM
}
  private var notUsed = true
def sndToM(m : MESSAGES.Main.FailMtoM) : __SndFailMtoWImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("M"),m)
__SndFailMtoWImp(c,session)}
def !(m : MESSAGES.Main.FailMtoM) : __SndFailMtoWImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("M"),m)
__SndFailMtoWImp(c,session)}
def snd(m : MESSAGES.Main.FailMtoM) : __SndFailMtoWImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("M"),m)
__SndFailMtoWImp(c,session)}

}


  trait SndFailMtoW extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeSnd
  object SndFailMtoW extends SndFailMtoW {
  override protected def __children: List[EPMain_zk_ZK] = List(End_zk_ZK_MainFHandling)
  override type implT = __SndFailMtoWImp
  override type implNextT = __End_zk_ZK_MainFHandlingImp
override def toString() : String = {"EPMain_zk_ZK.SndFailMtoW"}
    override def to : RRole = RoleSet("W") 
   override def l : String = "FailMtoW" 

  override protected def __create(c : AbstractChannel, session : Session) : implT = __SndFailMtoWImp(c,session)}

protected case class __SndFailMtoWImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    SndFailMtoW
}
  private var notUsed = true
def sndToW(m : MESSAGES.Main.FailMtoW) : __End_zk_ZK_MainFHandlingImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__End_zk_ZK_MainFHandlingImp(c,session)}
def !(m : MESSAGES.Main.FailMtoW) : __End_zk_ZK_MainFHandlingImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__End_zk_ZK_MainFHandlingImp(c,session)}
def snd(m : MESSAGES.Main.FailMtoW) : __End_zk_ZK_MainFHandlingImp = {
assert(notUsed, s"The channel send musted be used linear")
 notUsed=false
c.snd(RoleSet("W"),m)
__End_zk_ZK_MainFHandlingImp(c,session)}

}


protected  trait End_zk_ZK_MainFHandling extends EPMain_zk_ZK with event_lang.dsl.ChannelTypeEnd
protected  object End_zk_ZK_MainFHandling extends End_zk_ZK_MainFHandling {
  override protected def __children: List[EPMain_zk_ZK] = List()
  override type implT = __End_zk_ZK_MainFHandlingImp
  override type implNextT = Nothing
override def toString() : String = {"EPMain_zk_ZK.End_zk_ZK_MainFHandling"}
  
  override protected def __create(c : AbstractChannel, session : Session) : implT = __End_zk_ZK_MainFHandlingImp(c,session)}

protected case class __End_zk_ZK_MainFHandlingImp(private val c : AbstractChannel, session : Session) extends AbstractChannelImp {
  override def from : AbstractChannelType = {
    End_zk_ZK_MainFHandling
}
  
}


}

}

}
