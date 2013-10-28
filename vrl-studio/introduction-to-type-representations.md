CSS:	resources/css/vrl-documentation.css

# Introduction To Type Representations #

## Requirements ##
- VRL-Studio >= 4.5.x
- VRL >= 0.4.2.x

## Depends on ##
[What Is VRL-Studio?](what-is-vrl-studio.html)

[Defining a Workflow](defining-a-workflow.html)

## Contents ##

In this tutorial you will learn what type representations are and how to

- select between different type presentations
- customize type representations

## Difficulty Level ##
Intermediate

## Introduction ##

If you are not interested in the explanation of type representations, you may skip the introduction and continue with [Choosing Type Representations].

As already explained in [What Is VRL-Studio?](what-is-vrl-studio.html) VRL provides three types of visual components (see Figure [Component Types]) . This introduction is about parameter visualizations, i.e., type representations.

![Component Types][]

[Component Types]: resources/img/component-types01.png width=450px

Type representations are the most individual part of the VRL GUI generation. Method representations and Object representations are mainly containers and the possibilities to customize their appearance are rather limited. Type representations however are individual representations of parameters and return values.


## Choosing Type Representations ##
For each parameter type several type representations can be registered. In the case of `Integer` VRL provides 

- textfields
- sliders

## Available Type Representations ##

VRL provides type representations for a variety of types, such as

- java.lang.Short ([API doc](http://vrl.mihosoft.eu/api-doc/latest/eu/mihosoft/vrl/types/NumberBasedTypeRepresentation.html))
- java.lang.Integer ([API doc](http://vrl.mihosoft.eu/api-doc/latest/eu/mihosoft/vrl/types/NumberBasedTypeRepresentation.html), [Slider Type](http://vrl.mihosoft.eu/api-doc/latest/eu/mihosoft/vrl/types/IntSliderType.html))
- java.lang.Long ([API doc](http://vrl.mihosoft.eu/api-doc/latest/eu/mihosoft/vrl/types/NumberBasedTypeRepresentation.html))
- java.lang.Float ([API doc](http://vrl.mihosoft.eu/api-doc/latest/eu/mihosoft/vrl/types/NumberBasedTypeRepresentation.html))
- java.lang.Double ([API doc](http://vrl.mihosoft.eu/api-doc/latest/eu/mihosoft/vrl/types/NumberBasedTypeRepresentation.html))
- java.lang.String ([API doc](http://vrl.mihosoft.eu/api-doc/latest/eu/mihosoft/vrl/types/StringType.html), [Text Input Type](http://vrl.mihosoft.eu/api-doc/latest/eu/mihosoft/vrl/types/InputTextType.html))
- java.lang.Boolean
- java.awt.Image
- java.io.File
- ...


In addition many plugins provide their own type representations.

> **NOTE:** Check the [API doc](http://vrl.mihosoft.eu/api-doc/latest/eu/mihosoft/vrl/types/package-summary.html) for a complete list of supported types.


### Code Example ###

In the following example we will change the default type representation of a method parameter.

The code below defines a simple Groovy class that provides a method which adds two integer values.

    @ComponentInfo(name=AddIntegers, category="Custom")
    class AddIntegers {
		public Integer add( Integer a , Integer b) {
			return a+b;
		}
	}

The default visualization is shown in Figure [Add Integers].

![Add Integers][]

[Add Integers]: resources/img/add-integers-01.png width=450px

### Annotating Parameters ###
To request a different type representation one can annotate the parameter with a so called `@ParamInfo`:

    @ComponentInfo(name=AddIntegers, category="Custom")
    class AddIntegers {
		public Integer add(
		    @ParamInfo(style="slider") Integer a, Integer b) {
			return a+b;
		}
	}


Figure [Choosing a Slider] shows the difference between the default visualization and the new example with the slider.

![Choosing a Slider][]

[Choosing a Slider]: resources/img/slider-type-representation-01.png width=450px

> **NOTE:** for an introduction to Java annotations consult the official documentation: [Annotation Tutorial (Oracle)](http://docs.oracle.com/javase/tutorial/java/annotations/)

## Changing Parameter Options ##

In addition to selecting the type representation `@ParamInfo` can be used to specify

- the parameter name
- default value & value range
- other options (depends on the type representation)

### Examples ###
1.) Changing the parameter name:

    @ComponentInfo(name=AddIntegers, category="Custom")
    class AddIntegers {
		public Integer add(
		    @ParamInfo(name="My Name", style="slider") Integer a, Integer b) {
			return a+b;
		}
	}
	
2.) Defining `min=3 & max=10`:

    @ComponentInfo(name=AddIntegers, category="Custom")
    class AddIntegers {
		public Integer add(
		    @ParamInfo(name="My Name", style="slider", options="min=3; max=10;") Integer a,
		    Integer b) {
			return a+b;
		}
	}


## Further Reading ##

--


[<- Back To Help Index](index.html)
