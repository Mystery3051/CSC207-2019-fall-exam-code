# CSC207-2019-fall-exam-code
This code will be used in the CSC207 fall 2019 final exam.

1. Separate Dir and File in different classes, they should be used from the source code, but must not depend on each other.
They should depend on abstractions (Dependency Inversion? Maybe Single Responsibility Principle).

2. Both Dirs and Files are Nodes, but we can't use them as Nodes interdependently because we separate Files and Directories in different Lists.
They are all children Nodes and instanceof() is a code smell. Solution: Make one method to add children and forget about separation, there's
not much difference when it comes to Files and Directories. Cons: You don't enforce Files not having children.

3. There is a very bad thing that Files are never Observers, but Nodes are. That violates Interface Segregation Principle - never implement something
you will not use. That's why it is a good idea to make Directories Observers and Nodes just Observables. Then no need for update() method in File
that throws Exception.

Thanks to all of the awesome people in TLI I was discussing this code with. It is a collective work of all of us. Please, contribute to
extend the README and anything else you would like to work on. Good luck on exam!
