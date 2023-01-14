default: cpsc2150/interfaces/MultiSetApp.java cpsc2150/interfaces/DoubleSetApp.java cpsc2150/interfaces/ArraySet.java cpsc2150/interfaces/ListSet.java cpsc2150/interfaces/ISet.java cpsc2150/interfaces/SetAbs.java
	javac -Xlint:unchecked cpsc2150/interfaces/MultiSetApp.java cpsc2150/interfaces/DoubleSetApp.java cpsc2150/interfaces/ArraySet.java cpsc2150/interfaces/ListSet.java cpsc2150/interfaces/ISet.java cpsc2150/interfaces/SetAbs.java
runInt: cpsc2150/interfaces/MultiSetApp.class
	java cpsc2150/interfaces.MultiSetApp
runDouble: cpsc2150/interfaces/DoubleSetApp.class
	java cpsc2150/interfaces.DoubleSetApp
test: cpsc2150/interfaces/TestArraySet.java cpsc2150/interfaces/TestListSet.java cpsc2150/interfaces/MultiSetApp.java cpsc2150/interfaces/DoubleSetApp.java cpsc2150/interfaces/ArraySet.java cpsc2150/interfaces/ListSet.java cpsc2150/interfaces/ISet.java cpsc2150/interfaces/SetAbs.java
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/interfaces/TestArraySet.java cpsc2150/interfaces/TestListSet.java cpsc2150/interfaces/MultiSetApp.java cpsc2150/interfaces/DoubleSetApp.java cpsc2150/interfaces/ArraySet.java cpsc2150/interfaces/ListSet.java cpsc2150/interfaces/ISet.java cpsc2150/interfaces/SetAbs.java
testArr: cpsc2150/interfaces/TestArraySet.class
	java  -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.interfaces.TestArraySet
testList: cpsc2150/interfaces/TestListSet.class
	java  -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.interfaces.TestListSet
clean:
	rm -f cpsc2150/interfaces/*.class
