import org.gradle.api.tasks.JavaExec;
import org.gradle.internal.os.OperatingSystem;

import java.util.ArrayList;
import java.util.List;

public class MagicDrawExec extends JavaExec {

    public MagicDrawExec() {
        super();
        getMainClass().set("com.nomagic.magicdraw.Main");

        var installationDir = getProject().property("installationDir");

        setClasspath(getProject().fileTree(installationDir));

        setWorkingDir(installationDir);

        setStandardOutput(System.out);
        setErrorOutput(System.err);

        var os = OperatingSystem.current();

        final List<String> newArgs = new ArrayList<>();
        
//      jvm args from old gradle setup	  
//		jvmArgs = platformConfigSetting + ['-Xmx8192M', '-Xss512M', '-noverify', '-splash:data/splash.png','-Dmd.class.path=$java.class.path', '-Dlogback.configurationFile=data/logback.xml', '-Desi.system.config=data/application.conf']
        
        newArgs.add("-DWINCONFIG=" + Boolean.toString(os.isWindows()));
        if (os.isMacOsX()) {
            newArgs.add("-Xdock:name=MagicDraw");
            newArgs.add("-Xdock:icon=bin/md.icns");
            newArgs.add("-Dapple.laf.useScreenMenuBar=true");
        }
        
        jvmArgs(newArgs);
    }

    public MagicDrawExec setCliApplication(String applicationClassName) {
        getMainClass().set("com.nomagic.magicdraw.commandline.CommandLineActionLauncher");
        final List<String> cliArgs = new ArrayList<>();
        cliArgs.add("-Dcom.nomagic.magicdraw.launcher=com.nomagic.magicdraw.commandline.CommandLineActionLauncher");
        cliArgs.add("-Dcom.nomagic.magicdraw.commandline.action="+applicationClassName);
        jvmArgs(cliArgs);
        return this;
    }

}
