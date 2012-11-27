CSS:	resources/css/vrl-documentation.css

# Using The Shell #

## Requirements ##

- VRL-Studio >= 4.4.3
- VRL >= 0.4.2.7

## Depends On ##

[What Is VRL-Studio?](what-is-vrl-studio.html)

## Contents ##

In this tutorial you will learn how to

- use the Groovy shell that comes with VRL-Studio

## Difficulty Level##

Intermediate

## Introduction ##

The shell is an interactive command line interface that allows to control VRL-Studio.


### Opening The Shell ###

Drag the ruler up to show the log/shell (see [Show Shell], 1.). Now click on the `Shell` tab to show the shell (see [Show Shell], 2.)

![Show Shell][]

[Show Shell]: resources/img/show-shell-01.png width=450px


## Accessing The Help ##

When you first open the shell it shows some information about the operating system, Java and Groovy etc. Most importantly, it explains how to access the built-in help:

    *******************************************************************
                                 VRL-Shell                             
    -------------------------------------------------------------------
     => VRL-0.4.2.6-HEAD, build: 2012/11/26 16:53:41
     => Java-1.6.0_37 (Apple Inc.)
     => Groovy-1.8.8
     => OS: Mac OS X (x64)
     => pid: 690
    *******************************************************************
    Welcome, user! Type "sh:help" to get help.
    
    VRL:> 

Now type `sh:help` and press `Enter`. The shell will give you the following output:

    ------------------------ help ------------------------
    valid shell commands:
    - sh:clear   clears current input buffer
    - sh:variables   shows defined variables
    - sh:constants   shows defined constants
    - sh:restart   restarts shell (local variables and classes will be lost)
    - sh:save   saves current shell session as script
    - sh:execute   executes groovy script
    - :CMD     executes CMD on system shell (replace CMD with the desired command)
           Note: a) CMD must not be interactive or require terminal emulation!
                 b) $ character must be escaped, e.g., $ becomes \$
                 c) \ character must be escaped, e.g., C:\ becomes C:\\
    - #CMD     same as :CMD, but runs CMD in xterm.
           Note: a) xterm must be installed on your system!
                 b) Use this for interactive shell commands such as 'view' or 'vim'.
    - quit      quits this shell (if allowed)
    - exit      quits this shell (if allowed)
    - sh:help   shows this help message
    VRL:> 

This gives you an overview over the possibilities of the shell that are extensions to the functionality derived from Groovy.

## Executing Commands ##

As a first example, type `println "Hello, Shell"` and press `Enter`. It will show the following output:

    VRL:> println "Hello, Shell"
    Hello, Shell
    VRL:> 

## Defining Variables ##

This is an example on how to define custom variables:

    VRL:> a = 10
    out:> 10
    VRL:> b = 10
    out:> 10
    VRL:> c = a+ b
    out:> 20
    VRL:> 

To see which variables you defined, type `sh:variables`:

    VRL:> sh:variables
    ------------------------ variables ------------------------
    -> b type = java.lang.Integer
    -> c type = java.lang.Integer
    -> a type = java.lang.Integer
    VRL:>

## Built-In Constants ##

The shell comes with several built-in constants. To see a list of them, type `sh:constants`:

    VRL:> sh:constants
    ------------------------ constants ------------------------
    -> studio           type = eu.mihosoft.vrlstudio.main.Studio                          
    -> animationManager type = eu.mihosoft.vrl.animation.AnimationManager                 
    -> inspector        type = eu.mihosoft.vrl.reflection.VisualObjectInspector           
    -> canvas           type = eu.mihosoft.vrl.reflection.VisualCanvas                    
    -> windows          type = eu.mihosoft.vrl.reflection.VisualObjects                   
    -> sh               type = eu.mihosoft.vrl.lang.ShellControl                          
    -> effectpane       type = eu.mihosoft.vrl.visual.EffectPane                          
    -> typeFactory      type = eu.mihosoft.vrl.reflection.DefaultTypeRepresentationFactory
    -> project          type = eu.mihosoft.vrl.io.VProjectController                      
    -> input            type = java.io.PipedInputStream                                   
    -> lastResult       type = java.lang.Integer                                          
    -> classloader      type = eu.mihosoft.vrl.system.VClassLoader                        
    -> err              type = eu.mihosoft.vrl.lang.ShellView$ShellViewPrintStream        
    -> clipboard        type = eu.mihosoft.vrl.visual.Clipboard                           
    -> out              type = eu.mihosoft.vrl.lang.ShellView$ShellViewPrintStream        
    VRL:>

## Using The History ##

Sometimes you might want to repeat a previouslyexecuted command. By using the `Up` and `Down` arrow keys you can navigate through the history of shell commands.



## Further Reading ##

- [Debugging](debugging.html)



