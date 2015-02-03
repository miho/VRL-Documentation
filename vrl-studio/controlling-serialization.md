CSS:	resources/css/vrl-documentation.css

<!--VMM-INDEX=7-->

# Controlling Serialization #

## Requirements ##
- VRL-Studio >= 4.5.x
- VRL >= 0.4.2.x

## Depends on ##
[Introduction To Type Representations](introduction-to-type-representations.html)

## Contents ##

In this tutorial you will learn how to

- use the `transient` keyword to skip serialization for member variables
- tell type representations to skip parameter serialization

After reading this tutorial you will know how to significantly reduce the size of large projects.

## Difficulty Level ##
Intermediate

## Introduction ##

VRL-Studio tries to accurately serialize the project state which includes the state of all visual instances inside the project. 

Processing huge amounts of data, however, requires a deeper understanding of the underlying serialization techniques. By using annotations and the `transient` keyword provided by the Java/Groovy language the user gains control over the serialization process.

VRL-Studio project persistence heavily relies on binary object serialization[#Serialization] provided by the Java platform to ensure that also objects that do not comply with the JavaBean[#JavaBeans] specification can be serialized. For object instances that are visualized by the canvas VRL-Studio always uses binary serialization.

[#Serialization]:[http://docs.oracle.com/javase/7/docs/technotes/guides/serialization/](http://docs.oracle.com/javase/7/docs/technotes/guides/serialization/)

[#JavaBeans]:[http://docs.oracle.com/javase/tutorial/javabeans/](http://docs.oracle.com/javase/tutorial/javabeans/)

Depending on the type representation parameters are serialized via XML or Base64 encoded binary serialization. Type representations may implement custom rules for choosing between XML based or Base64 based serialization depending on the data that shall be serialized.

This tutorial will give useful hints on keeping the project size small. This highly influences the performance of I/O related tasks such as saving or loading projects.

## Transient Member Variables ##

The binary object serialization provided by Java tries to serialize the complete object state, including member variables. In many cases however, it is not necessary to serialize member variables. Therefore, it is advised to not serialize member variables if possible. To request this, Java/Groovy provides the keyword `transient`.

>**NOTE:** member variables that are not serializable prevent the object from being serialized. If it is not clear whether a member variable is serializable the `transient` keyword should be used. Otherwise object visualizations may be automatically removed when saving a project!

### Example: ###

The following example shows a class that has two member variables. The first one (`value1`) will be serialized. The second one (`value2`) will be skipped.

Code:

    @ComponentInfo(name=SampleClass, category="Custom")
    class SampleClass {
    	private int value1;          // value1 will be serialized
    	private transient int value2 // value2 will not be serialized
    }



## Controlling Parameter  Serialization ##

Also type representations serialize the state of the parameter object they visualize. For large objects it is strongly advised to disable parameter serialization.

### Controlling Parameter Serialization ###
Consider the following sample code:

    @ComponentInfo(name=SampleClass, category="Custom")
    class SampleClass {
      public void doSomething(
    	  @ParamInfo(options="") List<Integer> list1,
    	  @ParamInfo(options="") List<Integer> list2    	) {
    	  // ...
      }
    }

The class SampleClass provides the method `doSomething` that takes two `java.util.List<Integer>` objects. If the lists contain many objects this causes significant overhead when saving the project.

### Using @ParamInfo To Skip  Serialization Of Selected Parameters: ###

To skip serialization for specific parameters it is possible to specify a serialization option in the corresponding param info: `@ParamInfo(options="serialization=false")`.

Code:

    @ComponentInfo(name=SampleClass, category="Custom")
    class SampleClass {
    	public void doSomething(
    	  @ParamInfo(options="") List<Integer> list1,                   // will be serialized
    	  @ParamInfo(options="serialization=false") List<Integer> list2 // will not be serialized
        ) {
    	  // ...
        }
    }


### Using @ObjectInfo To Skip Parameter Serialization For A Custom Class ###

If the custom class extends a serializable class each parameter reference will be serialized. 

But if the custom class shall never be serialized if used as parameter one can disable the serialization by annotating the class.

Consider the following class:

    @ComponentInfo(name=SampleClass, category="Custom")
    class SampleClass extends ASerializableClass {
        // ...
    }
    

Adding `@ObjectInfo(serializeParam=false)` below `@ComponentInfo` specifies that parameter references of this class shall not be serialized.

Code:

    @ComponentInfo(name=SampleClass, category="Custom")
    @ObjectInfo(serializeParam=false)
    class SampleClass extends ASerializableClass {
        // ...
    }



## Further Reading ##

--


[<- Back To Help Index](index.html)
