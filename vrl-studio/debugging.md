CSS:	resources/css/vrl-documentation.css

# Debugging #

## Requirements ##

- VRL-Studio >= 0.4.4.3
- VRL >= 0.4.2.7

## Depends On ##

[Using The Shell](using-the-shell.html)

## Contents ##

In this tutorial you will learn how to

- enable debug output
- find bugs in your code
- perform visual debugging

## Difficulty Level ##

Intermediate

## Introduction ##

Groovy is a dynamic language. Current versions of Groovy (< 2.0) do not support static compilation. Thus, many errors occur at runtime. Even though dynamic languages tend to have a flat learning curve they often make it difficult to find bugs in the code. Many errors can only be detected if the code is executed. For code that contains several conditional statements this can be problematic.

VRL provides some basic debugging features that may help finding bugs in your code.


### Enabling Debug Output ###

Click on `Edit->Preferences` and then on the `Development` tab (see [Enable Logging]). Here you can enable 

- `System.out` : shows usual text output, e.g., `println("msg")`
- `System.err` : shows error output, e.g., stack traces etc.

![Enable Logging][]

[Enable Logging]: resources/img/enable-logging-01.png width=450px

Drag the ruler up to show the log (see [Show Log]). Now you can see VRL debug output in the log.

![Show Log][]

[Show Log]: resources/img/show-log-01.png width=450px

## Debugging Code ##

### Basic Example ###

Consider the following code:

    package eu.mihosoft.vrl.user;
    @ComponentInfo(name="BuggyClass", category="Custom")
    class BuggyClass implements Serializable {
      private static final long serialVersionUID=1;

      public String letItCrash(){
        String s = "a string";
        s.thisMethodDoesNotExist();
        return "Nice! It doesn't crash anymore!";
      }
    }

It compiles without problems. But when you run it you will get an error message:

![Error Message][]

[Error Message]: resources/img/debugging-error-msg-01.png width=650px

Obviously, we try to call a method that doesn't exist. The compiler does not complain because method calls are checked at runtime.

### Reading The Log ###

If the code you are trying to debug is very long and complicated it might be difficult to figure out where the exception was thrown. Therefore it might be useful to look at the stack trace. We do this by opening the log (see [Show Log]).

The log gives us the following output:

    Method "eu.mihosoft.vrl.user.BuggyClass.letItCrash()" can't be invoked:groovy.lang.MissingMethodException: No signature of method: java.lang.String.thisMethodDoesNotExist() is applicable for argument types: () values: []
    No signature of method: java.lang.String.thisMethodDoesNotExist() is applicable for argument types: () values: []
     --> at org.codehaus.groovy.runtime.ScriptBytecodeAdapter.unwrap(ScriptBytecodeAdapter.java:52)
     --> at org.codehaus.groovy.runtime.callsite.PojoMetaClassSite.call(PojoMetaClassSite.java:43)
     --> at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:39)
     --> at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:105)
     --> at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:109)

    --------------------------
     --> at eu.mihosoft.vrl.user.BuggyClass.letItCrash(BuggyClass.groovy:11) <-- PROJECT CLASS!
    --------------------------

     --> at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-5)
     --> at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:36)
     --> at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:22)
     --> at java.lang.reflect.Method.invoke(Method.java:594)
     --> at eu.mihosoft.vrl.reflection.ObjectInspector.invoke(ObjectInspector.java:185)
     --> at eu.mihosoft.vrl.reflection.VisualObjectInspector.invoke(VisualObjectInspector.java:625)
     --> at eu.mihosoft.vrl.reflection.VisualObjectInspector.invoke(VisualObjectInspector.java:592)
     --> at eu.mihosoft.vrl.reflection.DefaultMethodRepresentation.invoke(DefaultMethodRepresentation.java:1051)
     --> at eu.mihosoft.vrl.reflection.DefaultMethodRepresentation.invoke(DefaultMethodRepresentation.java:1236)
     --> at eu.mihosoft.vrl.reflection.DefaultMethodRepresentation.invoke(DefaultMethodRepresentation.java:1248)
     --> at eu.mihosoft.vrl.reflection.DefaultMethodRepresentation$6.run(DefaultMethodRepresentation.java:730)
     --> at java.lang.Thread.run(Thread.java:677)
    Can't invoke Method: see stack trace for details!

At first sight this output might look scary and complicated. However, it is actually very simple. The stack trace shows all method calls that are involved in the execution that led to the runtime error. In addition, method calls from classes that are defined in the VRL project, i.e., the classes that we defined via Groovy code, can be easily distinguished from other method calls. In our example it is the invocation of our `letItCrash()` method:

    --------------------------
     --> at eu.mihosoft.vrl.user.BuggyClass.letItCrash(BuggyClass.groovy:11) <-- PROJECT CLASS!
    --------------------------

The [Error Message] already shows what's wrong. But still we don't exactly know where the error occurred. Therefore, it is very useful to check the stack trace which exactly shows where an error occurred. In our case the error occurred in the class `BuggyClass`, line 11.

## Breakpoints ##

VRL comes with a utility class that allows to stop a visually invoked method at certain points. Therefore, the `VDebug` class can be used. To add a breakpoint to the code shown above we change it a bit:

    package eu.mihosoft.vrl.user;
    @ComponentInfo(name="BuggyClass", category="Custom")
    class BuggyClass implements Serializable {
      private static final long serialVersionUID=1;

      public String letItCrash(){
        String s = "a string";
		VDebug.setBreak("01") // --> BREAKPOINT 01
        s.thisMethodDoesNotExist();
        return "Nice! It doesn't crash anymore!";
      }
    }

Now click on `invoke`. Nothing happens. That is exactly what we intended. In the log VRL indicates that the method waits at breakpoint `"01"`:

    >> VDebug: waiting at breakpoint [01]

To continue the execution, we have to open the shell. First, type `VDebug.at()` to check the current position:

    VRL:> VDebug.at()
    out:> VDebug: currently at: [01]
    VRL:> 

Now type `VDebug.step()` to continue the execution. This will cause the exception discussed above (see [Reading The Log]).

## Visual Debugging ##

### What is Visual Debugging? ###

Sometimes you might be interested in the state of member variables of a visualized object. In a classical IDE one would observe the variable by compiling/running the program in debug mode. This would allow for detailed analysis of all members etc.

VRL-Studio has a feature called *Visual Debugging*.  Even though it cannot fully replace a classical debugger it highly simplifies the analysis of visualized objects. It allows you to access objects that are visualized on the canvas from the shell environment.

### Accessing Objects From The Shell ###

Consider the following code:

    @ComponentInfo(name="PrivateMemberObject", category="Custom")
    public class PrivateMemberObject implements java.io.Serializable {
      private static final long serialVersionUID=1L;
    
      public int value;
    
      public void aMethod(int value) {
        value = value;
      }
    }

We define a class that has one member and a method that shall set this member. Unfortunately, there is no way to visually access the member as there is no getter-method.

First, create an instance of the `MemberObject` class. This is how it should look like:

![Member Object 1][]

[Member Object 1]: resources/img/visual-debugging-member-object-01.png width=650px

Before we start analyzing the object from the shell you should invoke the `aMethod()` method with an input value `!=0`.

To access the `MemberObject` instance from the shell select the window by performing `CTRL -> Left Click` on the titlebar. The window will turn blue to indicate that it has been selected:

![Member Object 2][]

[Member Object 2]: resources/img/visual-debugging-member-object-02.png width=650px

Now go to the shell and type `obj = sh.getObject(clipboard[0])`:

    VRL:> obj = sh.getObject(clipboard[0])
    out:> eu.mihosoft.vrl.user.MemberObject@398a9f36
    VRL:> 

This defines the variable `obj` in the shell environment. You can check that via `sh:variables`:

    VRL:> sh:variables
    ------------------------ variables ------------------------
    -> obj type = eu.mihosoft.vrl.user.MemberObject
    VRL:> 

Analyzing the object is now very easy. Just type `obj.value` to show the variable in the shell:

    VRL:> obj.value
    out:> 0
    VRL:> 

As you have executed the method with a value `!=0` before you probably expected a different output from the shell. To fix this bug, recall the implementation of `aMethod`:

    public void aMethod(int value) {
      value = value;
    }

Now fix this issue bychanging it to:

    public void aMethod(int value) {
      this.value = value;
    }

This is necessary as the parameter of the method has the same name as the member variable. To distinguish them, it it necessary to use `this.value`.

You may now repeat the assignment of the `obj` variable and check that it correctly sets the member variable. Assuming that you called the `aMethod()` with input value `2` this is the shell output:

    VRL:> obj = sh.getObject(clipboard[0])
    out:> eu.mihosoft.vrl.user.MemberObject@398a9f36
    VRL:> obj.value
    out:> 2
    VRL:> 

## Further Reading ##

-



