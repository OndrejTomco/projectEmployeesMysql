package sk.sovy.emp;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sk.sovy.emp.resources.Employees;

public class HelloWizardApplication extends Application<HelloWizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloWizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloWizard";
    }

    @Override
    public void initialize(final Bootstrap<HelloWizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HelloWizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(
                new Employees()
        );
    }

}
