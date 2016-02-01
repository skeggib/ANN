JC = javac
JCR = java

.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \

default: classes exec-tests

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class *~


.PHONY: default clean classes exec-tests