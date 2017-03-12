package Command.base

class Processor(val commands: List<Command>,
                val help: Command) {

  fun process(command: String): Command {
    return commands
      .filter { it.matches(command) }
      .getOrElse(0) { help }
  }

}
