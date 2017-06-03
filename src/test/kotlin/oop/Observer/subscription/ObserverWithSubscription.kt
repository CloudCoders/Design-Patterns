package oop.Observer.subscription

import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldEqual
import io.kotlintest.specs.WordSpec

class ObserverWithSubscription : WordSpec() {

  init {
    "SubjectPublish" should {
      val observers = mutableListOf<Observer<String>>()
      val subject: PublishSubject<String> = PublishSubject(observers)

      "register a observer" {
        subject.register(Observer("hello world"))
        observers.size shouldBe 1
      }

      "register a observer and notify it" {
        val observer = MockObserver("Hello world")
        subject.register(observer)
        subject.notify("Next")
        observer.hasUpdateCalled shouldBe true
        observer.value shouldBe "Next"
      }

    }

    "Observable" should {

      "call success on subscription" {
        var hasCalled: Boolean = false
        val observer = Observer("Hello world")
        val success: (String) -> Unit = { value ->
          hasCalled = true
          value shouldBe "Hello world"
        }
        observer.subscribe(success, { 2 shouldBe 3 })
        hasCalled shouldBe true
      }

      "update value if is subscribed" {
        var hasCalled: Boolean = false
        val observer = Observer("Hello world")
        val update: (String) -> Unit = { value ->
          hasCalled = true
          value shouldBe "Updated"
        }
        val subscription = observer.subscribe({}, update)
        observer.update("Updated")
        hasCalled shouldBe true
        subscription.isSubscribed shouldBe true
      }


      "not update if is not subscribed" {
        var hasCalled: Boolean = false
        val observer = Observer("Hello world")
        val update: (String) -> Unit = { hasCalled = true }
        val subscription = observer.subscribe({}, update)
        subscription.unregister()
        observer.update("Updated")
        hasCalled shouldBe false
        subscription.isSubscribed shouldBe false
      }

      "update if was not subscribed but renew the subscription"{
        var hasCalled: Boolean = false
        val observer = Observer("Hello world")
        val update: (String) -> Unit = { value ->
          hasCalled = true
          value shouldBe "Updated"
        }
        val subscription = observer.subscribe({}, update)
        subscription.unregister()
        subscription.register()
        observer.update("Updated")
        hasCalled shouldBe true
        subscription.isSubscribed shouldBe true
      }
    }
  }

}


class MockObserver(value: String) : Observer<String>(value) {

  var hasUpdateCalled = false
  var value: String = ""

  override fun update(value: String) {
    this.hasUpdateCalled = true
    this.value = value
  }
}

