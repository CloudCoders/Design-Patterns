package oop.Proxy

interface Screen {
  fun show()
}

class ScreenVirtualProxy(val createRealScreen: () -> Screen) : Screen {

  var realScreen: Screen? = null

  override fun show() {
    if (realScreen == null) {
      realScreen = createRealScreen()
    }

    realScreen?.show()
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
