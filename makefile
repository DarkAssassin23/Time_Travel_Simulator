JAR = 'time_travel.jar'
JC = javac

# Source Dirs
SRC = .

MAIN = TimeTravel

#Class Files Directory
BINDIR = bin

JCFLAGS = -cp $(SRC) -sourcepath $(SRC) -d $(BINDIR)

#Source Files
SRCS = $(wildcard $(SRC)/*.java)

#Class Files
CLS = $(patsubst $(SRC)/%,$(BINDIR)/%,$(patsubst %.java,%.class,$(SRCS)))

default: $(CLS)
all: jar

$(BINDIR)/%.class: %.java
	@mkdir -p $(@D)
	$(JC) $(JCFLAGS) $<
	
jar: $(CLS)
	jar cfe $(JAR) $(MAIN) -C $(BINDIR) .
	
clean:
	$(RM) -r $(BINDIR) $(JAR)

