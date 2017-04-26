package oop.Proxy

interface Screen {
  fun show()
}

class ScreenVirtualProxy(val createRealScreen: () -> Screen) : Screen {

  val realScreen: Screen by lazy {
    createRealScreen()
  }

  override fun show() {
    realScreen.show()
  }
}

class RealScreen : Screen {
  constructor() {
    //init wtf recurses like chrome
  }

  override fun show() {
    println(" )_(o.O)_( ")
  }
}
