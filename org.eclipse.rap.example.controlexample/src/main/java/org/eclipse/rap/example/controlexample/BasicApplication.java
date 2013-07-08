package org.eclipse.rap.example.controlexample;

import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.internal.application.ApplicationImpl;

import com.eclipsesource.tabris.TabrisClientInstaller;
import com.eclipsesource.tabris.internal.TabrisClientProvider;

public class BasicApplication implements ApplicationConfiguration {

	public void configure(Application application) {
		TabrisClientInstaller.install(application);
		((ApplicationImpl) application).addClientProvider(new TabrisClientProvider());
		application.addEntryPoint("/hello", BasicEntryPoint.class, null);
	}

}
