@echo off
:: ---------------------------------------------------------------------
:: CUSTOM SCRIPT FOR PROJECT BUILD
:: ---------------------------------------------------------------------

CLS

:: Enable Delayed Expansion for handling spaces
SETLOCAL ENABLEDELAYEDEXPANSION

:: LOCAL VARIABLES ....................................................
SET "LIBDIR=lib"
SET "SRCDIR=%CD%\src"
SET "BINDIR=%CD%\out\production\untitled"
SET "BINERR=javac.err"
SET "JARNAME=untitled.jar"
SET "JAROUT=jar.out"
SET "JARERR=jar.err"
SET "DOCDIR=doc"
SET "DOCERR=javadoc.err"
SET "ARTIFACTDIR=%CD%\out\artifacts\untitled_jar"
SET "MAINCLASSSRC=%SRCDIR%\Main.java"
SET "MAINCLASSBIN=Main"

ECHO ===============================================
ECHO       JAVA PROJECT BUILD SCRIPT
ECHO ===============================================
ECHO
ECHO ========================================================
ECHO ATTENTION: PLEASE USE JAVA 8 OR LATER
ECHO ========================================================
ECHO
ECHO Do you want to use the system's default JDK? (y/n)
SET /P use_default=

IF /I "%use_default%"=="y" (
    SET "JAVA_CMD=java"
    SET "JAVAC_CMD=javac"
    SET "JAR_CMD=jar"
    SET "JAVADOC_CMD=javadoc"
) ELSE (
    ECHO Enter the path to your JDK (e.g., "C:\Program Files\Java\jdk-17")
    SET /P JDK_PATH=

    IF NOT EXIST "%JDK_PATH%" (
        ECHO Invalid JDK path! Exiting...
        PAUSE
        EXIT /B 1
    )

    SET "JAVA_HOME=%JDK_PATH%"
    SET "PATH=%JAVA_HOME%\bin;%PATH%"

    SET "JAVA_CMD=%JAVA_HOME%\bin\java"
    SET "JAVAC_CMD=%JAVA_HOME%\bin\javac"
    SET "JAR_CMD=%JAVA_HOME%\bin\jar"
    SET "JAVADOC_CMD=%JAVA_HOME%\bin\javadoc"
)

ECHO [BUILD PROCESS ---------------------]

:: Ensure necessary directories exist
IF NOT EXIST "%BINDIR%" MKDIR "%BINDIR%"
IF NOT EXIST "%ARTIFACTDIR%" MKDIR "%ARTIFACTDIR%"
IF NOT EXIST "%DOCDIR%" MKDIR "%DOCDIR%"
IF NOT EXIST "%LIBDIR%" MKDIR "%LIBDIR%"

:: Step 1: Compile Java files
ECHO 1. Compiling ......................
DIR /S /B "%SRCDIR%\*.java" > sources.txt
"%JAVAC_CMD%" -Xlint -cp ".;%SRCDIR%;%LIBDIR%\*" @sources.txt -d "%BINDIR%" 2> "%BINERR%"
DEL sources.txt

IF %ERRORLEVEL% NEQ 0 (
    ECHO Compilation failed! Check %BINERR% for details.
    EXIT /B 1
)

ECHO Compilation successful!

:: Step 2: Create JAR file
ECHO 2. Creating Jar ...................

PUSHD "%BINDIR%"
ECHO Running JAR command: "%JAR_CMD%" cvfe "%ARTIFACTDIR%\%JARNAME%" "%MAINCLASSBIN%" .
"%JAR_CMD%" cvfe "%ARTIFACTDIR%\%JARNAME%" "%MAINCLASSBIN%" . > "%CD%\%JAROUT%" 2> "%CD%\%JARERR%"
POPD

IF NOT EXIST "%ARTIFACTDIR%\%JARNAME%" (
    ECHO Error: JAR file not found! Something went wrong in creation.
    TYPE "%JARERR%"
    EXIT /B 1
)

:: Step 3: Generate Javadoc
ECHO 3. Creating Javadoc ...............
ECHO Checking for source directory at: "%SRCDIR%"

IF NOT EXIST "%SRCDIR%" (
    ECHO Error: Source directory "%SRCDIR%" not found!
    EXIT /B 1
)

DEL java_files_list.txt 2>nul
DIR /S /B "%SRCDIR%\*.java" > java_files_list_raw.txt

(
    FOR /F "delims=" %%A IN (java_files_list_raw.txt) DO (
        SET "filePath=%%A"
        SETLOCAL ENABLEDELAYEDEXPANSION
        ECHO "!filePath:\=\\!" >> java_files_list.txt
        ENDLOCAL
    )
)

DEL java_files_list_raw.txt

IF %ERRORLEVEL% NEQ 0 (
    ECHO No Java files found to document.
    EXIT /B 1
)

"%JAVADOC_CMD%" -cp ".;%BINDIR%;%LIBDIR%\*" -d "%DOCDIR%" @"java_files_list.txt" 2> "%DOCERR%"
DEL java_files_list.txt

:: Step 4: Run the JAR file
ECHO 4. Running Jar ....................
ECHO "%ARTIFACTDIR%\%JARNAME%"
"%JAVA_CMD%" -jar "%ARTIFACTDIR%\%JARNAME%"

ECHO [END OF SCRIPT -------------------]
ECHO
@echo on

:: ---------------------------------------------------------------------
:: End of Script
:: ---------------------------------------------------------------------
ENDLOCAL
