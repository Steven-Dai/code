package site.daishuyang.dataway.demo;

import org.springframework.stereotype.Component;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.core.Module;

/**
 * MyModule
 */
@DimModule
@Component
public class MyModule implements Module {

    @Override
    public void loadModule(ApiBinder arg0) throws Throwable {
        System.out.println("loadModule 执行了……");
    }


    
}