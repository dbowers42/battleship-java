clean:
	@rm battleship.jar

build:
	@echo "building jar..."
	@jar cfm battleship.jar manifest.mf -C target/classes .

run:
	@java -jar battleship.jar