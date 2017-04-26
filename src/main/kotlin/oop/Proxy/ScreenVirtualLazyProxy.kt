package oop.Proxy

class ScreenVirtualLazyProxy : Screen {
  val realScreen: Screen by lazy {
    RealScreen()
  }

  override fun show() {
    realScreen.show()
  }
}
