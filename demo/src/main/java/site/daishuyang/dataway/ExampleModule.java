package site.daishuyang.dataway;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;

/**
 * ExampleModule
 */
@DimModule
@Component
public class ExampleModule implements SpringModule {

    @Autowired
    private DataSource dataSource = null;

    @Override
    public void loadModule(ApiBinder arg0) throws Throwable {
        arg0.installModule(new JdbcModule(Level.Full, this.dataSource));
    }

}