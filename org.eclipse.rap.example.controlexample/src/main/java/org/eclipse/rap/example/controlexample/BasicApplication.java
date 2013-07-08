package org.eclipse.rap.example.controlexample;

import static com.eclipsesource.tabris.internal.Constants.THEME_ID_ANDROID;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.rap.example.imageexample.ImageEntryPoint;
import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.internal.application.ApplicationImpl;
import org.eclipse.rap.rwt.service.ResourceLoader;

import com.eclipsesource.tabris.TabrisClientInstaller;
import com.eclipsesource.tabris.internal.TabrisClientProvider;

public class BasicApplication implements ApplicationConfiguration {
	
	private static class ResourceLoaderImpl implements ResourceLoader {

		public InputStream getResourceAsStream(String resourceName) throws IOException {
			return BasicApplication.class.getResourceAsStream(resourceName);
		}
	}

	public void configure(Application application) {
		TabrisClientInstaller.install(application);
		((ApplicationImpl) application).addClientProvider(new TabrisClientProvider());
	    application.addStyleSheet( THEME_ID_ANDROID, "theme-android-holo.css", new ResourceLoaderImpl() );
		application.addEntryPoint("/hello", BasicEntryPoint.class, null);
		application.addEntryPoint("/image", ImageEntryPoint.class, null);
	}
}
