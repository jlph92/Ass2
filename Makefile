all: test

%.class: %.java *.java
	javac $<

test: TestSuite.class
	java -ea RunTests TestSuite

clean:
	-rm *.class .class
