DrMIPS
======

DrMIPS is a graphical simulator of the [MIPS][MIPS] processor to support
computer architecture teaching and learning. It is intuitive, versatile and
configurable.
The simulator is available not only for personal computers but also for Android
devices, especially tablets.

DrMIPS was created under the Master's dissertation entitled
[Tool to Support Computer Architecture Teaching and Learning][DISS] at
[FEUP][FEUP].

Check the [project's page][page] for information on how to use the simulator.

DrMIPS is open-source and licensed under the [GPLv3][gpl3], so you are free to
use, redistribute and modify it (under certain conditions).


Compiling DrMIPS
----------------

[CMake][cmake] is used to compile the simulator.

To compile it:

1.  Run `cmake .`, `ccmake .` or `cmake-gui .` from the root directory of the
    repository to generate the makefiles.

    You could instead (and it's recommended to) run one of the above commands
    from a separate build-directory.
    To do that, create a new folder (named *build*, for example) in the root
    directory of the repository and run `cmake ..`, `ccmake ..` or `cmake-gui ..`
    from that folder.

2.  Configure the compilation options with `ccmake` or `cmake-gui`.

3.  Compile the simulator by running `make` from the directory where CMake was
    executed.

4.  Run `make dist` from that directory to create a ZIP file for distribution of
    the PC version of the simulator.


Project Directories
-------------------

* **cmake**: additional modules used by the CMake build scripts.
* **doc**: documentation of the project.
    * **manuals**: user manuals.
    * **UML**: simple UML class diagram of the simulator.
* **src**: source code of the project.
    * **android**: code of the Android application (graphical interface).
    * **pc**: code of the PC application (graphical interface).
    * **simulator**: code of the internal simulation logic (cross-platform).
* **misc**: some miscellaneous files used by Linux packages.



[DISS]: http://paginas.fe.up.pt/~ei08109/dissertation/ "Dissertation Wiki"
[FEUP]: http://www.fe.up.pt/ "Faculty of Engineering of the University of Porto"
[MIPS]: http://en.wikipedia.org/wiki/MIPS_architecture "MIPS architecture"
[page]: http://brunonova.github.io/drmips/ "DrMIPS"
[cmake]: http://www.cmake.org/ "CMake - Cross Platform Make"
[gpl3]: http://www.gnu.org/licenses/gpl-3.0.html "GNU General Public License v3"