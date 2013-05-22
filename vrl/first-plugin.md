CSS:        resources/css/vrl-documentation.css

# Create your first VRL - Plugin #

## Content ##

In this tutorial you will learn to:

- [Create a VRL - Plugin] with a simple String;
- [Committing your new Plugin to GitHub];


## Create a VRL - Plugin [Create a VRL - Plugin] ##

- NetBeans -> File -> New Project... -> Categories: java; Projects: Java Application -> Next -> Project Name: (for example: Test-VRL-Tutorial-Plugin-01); Create Main Class: (for example: edu.gcsc.vrl.tutorial.TestTutorialComponent01) -> `Finish`

- In Projects: Plugin-01 -> Libraries: right mouse click -> Add Project... -> VRL - dist/VRL.jar -> OK.
- Important is in Project Properties: Source JDK 1.6;


![tut-component-01][]

[tut-component-01]: resources/img/tut-component-01.png width=980px	

We open TestTutorialComponent01.java and write:


	package edu.gcsc.vrl.tutorial;
	
	import eu.mihosoft.vrl.annotation.ComponentInfo;
	import java.io.Serializable;
	
	@ComponentInfo(name="TestTutorialComponent01", 
	        category="TestTutorialPlugin/01", 
	        description="My Component")
			
	public class TestTutorialComponent01 implements Serializable{
    
    
	    private static final long serialVersionUID = 1L;
    
    
	    public String doSomething() {
	        return "Congratulations! "
	                + "Your new project works!";
	    }
	}

Then we create TutorialPluginConfigurator.java and copy the code:

- du.gcsc.vrl.tutorial -> right mouse click -> New -> Java class -> Class Name: (for example: TestTutorialPluginConfigurator) -> `Finish`

![create TutorialPluginConfigurator][]

[create TutorialPluginConfigurator]: resources/img/createTutConfConfigurator.png width=980px	


	package edu.gcsc.vrl.tutorial;
	
	import eu.mihosoft.vrl.system.InitPluginAPI;
	import eu.mihosoft.vrl.system.PluginAPI;
	import eu.mihosoft.vrl.system.PluginIdentifier;
	import eu.mihosoft.vrl.system.VPluginAPI;
	import eu.mihosoft.vrl.system.VPluginConfigurator;
	
	/**
	*
	* @author Michael Hoffer <info@michaelhoffer.de>
	*/
	
	public class TestTutorialPluginConfigurator extends VPluginConfigurator{
	
    public TestTutorialPluginConfigurator() {
        //specify the plugin name and version
       setIdentifier(new PluginIdentifier("TestTutorial-Plugin01", "0.1"));
	   
       // describe the plugin
       setDescription("Plugin Description");
	   
       // copyright info
       setCopyrightInfo("Sample-Plugin",
               "(c) Your Name",
               "www.you.com", "License Name", "License Text...");
    }
    
    @Override
    public void register(PluginAPI api) {
		
       // register plugin with canvas
       if (api instanceof VPluginAPI) {
           VPluginAPI vapi = (VPluginAPI) api;
           vapi.addComponent(TutorialComponent01.class);
		   }
	}
	
    @Override
    public void unregister(PluginAPI api) {
       // nothing to unregister
    }
	
    @Override
    public void init(InitPluginAPI iApi) {
       // nothing to init
	  }
	}


- Test-VRL-Tutorial-Plugin-01 -> Build;

- VRL-Studion -> Run
- `Create` your new project

![create VRL-Studio project][]

[create VRL-Studio project]: resources/img/create-VRL-Studio-project.png width=980px	

- Save for example as "Test-VRL-Tut-01";
- (in top-menu) Plugins -> Install Plugin -> (search in "NetBeans", in your project "Test-VRL-Tut-01/dist" the file "Test-VRL-Tut-Plugin-01.jar")
/Users/userNN/NetBeansProjects/Test-VRL-Tut-01/dist/Test-VRL-Tut-01.jar
-> open 

![instal plugin][]

[instal plugin]: resources/img/instal-plugin.png width=980px	

- Save your project.
- Restart VRL-Studio to use the plugins;
- open your new project "Test-VRL-Tut-01.vrlp";
- (in top-menu) File -> Select Plugins 

![select plugins][]

[select plugins]: resources/img/select-plugins.png width=980px	

- (select the plugins you need) -> OK
- (right mouse-click in VRL) -> Manage Components
- Now you have your new Plugin in "Manage Components" -> Components -> TestTutorialPlugin -> 01 -> TestTutorialComponent01;

- pull your new plugin "TutorialComponent01" into development area and click `invoke`;
- you will get your text in the plugin: "Congratulations! Your new project works!"

![plugin-ready][]

[plugin-ready]: resources/img/plugin-ready.png width=980px	

That means that your plugin works! ;)


------

To export your whole VRL-Project (with plugins):

- (in top-menu VRL-Studio) -> File -> Export Project -> `Yes` -> FileName.vrlp -> Save

-----


####you can also load the example plugin from GitHub:  [Test-VRL-Tut-Plugin-01.zip](https://github.com/Elena23/VRL-Tutorials/blob/master/Test-VRL-Tut-Plugin–01.zip) ####


## Committing your new Plugin to GitHub [Committing your new Plugin to GitHub]##

###1. Create your new Repository in GitHub:###

- Login you at GitHub
- Click upper right on book icon "Create a new repo";
- Write the name of repository (for example: Your-Repository-01):

![create-repository][]

[create-repository]: resources/img/create-repository.png width=980px

- ->`Create repository` 

- copy the git-adress (for git remote add ...):

![git-address][]

[git-address]: resources/img/git-address.png width=980px


###2. Initialize a git repository for the project local and push it to github:###

 Open the Terminal on your computer and write the address of your project in NetBeans, for example:

		cd NetBeansProjects/Test-VRL-Tut-Plugin-01 
// it means that you go to the directory where your plugin is located, you can see the address in NetBeans in Project Properties;

![git-init][]

[git-init]: resources/img/git-init.png width=980px	

		git init 
 // it means that you Initialise Git-Repository local;
  		   
		git add .
		git commit -a -m "your commentar"
		git remote set-url origin git@github.com:Elena23/Test-VRL-Tut-Plugin-01.git
		git push -u origin master 
 // Initialize a new git repository local, then stage all the files in the directory, then commit the initial snapshot and finally push it into GitHub branch master;
  

####Finished! Now your plugin is in GitHub!###
  
  
  
This commands can help you:  

		cd ../ 
// to back out one level out of the current directory;
 
		ls -la
// it shows all files in this directory;

		git status
// it shows the status;

		man git 
// this is Git Manual 

//Click 'q' to get out of Manual;



For other Git-Commands look here:  
[Git Cheat Sheet](https://na1.salesforce.com/help/doc/en/salesforce_git_developer_cheatsheet.pdf)












