package org.eclipse.rap.example.controlexample;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.rap.example.imageexample.ImageEntryPoint;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.client.Client;
import org.eclipse.rap.rwt.internal.application.ApplicationImpl;
import org.eclipse.rap.rwt.internal.theme.ThemeUtil;
import org.eclipse.rap.rwt.service.ResourceLoader;

import com.eclipsesource.tabris.TabrisClientInstaller;
import com.eclipsesource.tabris.internal.Constants;
import com.eclipsesource.tabris.internal.TabrisClient;
import com.eclipsesource.tabris.internal.TabrisClientProvider;

public class BasicApplication implements ApplicationConfiguration {
	
	public static final String ID_SWT = "com.eclipsesource.tabris.swt";
	public static final String THEME_ID_SWT = "com.eclipsesource.rap.mobile.theme.swt";

	class CustomTabrisClientProvider extends TabrisClientProvider {


		public String getPlatform() {
			String userAgent = RWT.getRequest().getHeader(Constants.USER_AGENT);
			if (userAgent != null && userAgent.contains(ID_SWT)) {
				return ID_SWT;
			}

			return null;
		}

		@Override
		public boolean accept(HttpServletRequest request) {
			String platform = getPlatform();
			if (platform != null && platform.equals(ID_SWT)) {
				ThemeUtil.setCurrentThemeId(RWT.getUISession(), THEME_ID_SWT);
				return true;
			}
			return super.accept(request);
		}

		@Override
		public Client getClient() {
			return new TabrisClient();
		}
	}

	private static class ResourceLoaderImpl implements ResourceLoader {

		public InputStream getResourceAsStream(String resourceName)
				throws IOException {
			return BasicApplication.class.getResourceAsStream(resourceName);
		}
	}

	public void configure(Application application) {
		TabrisClientInstaller.install(application);
		((ApplicationImpl) application)
				.addClientProvider(new CustomTabrisClientProvider());
		application.addStyleSheet(THEME_ID_SWT, "theme-swt-macos.css",
				new ResourceLoaderImpl());
		application.addEntryPoint("/hello", BasicEntryPoint.class, null);
		application.addEntryPoint("/image", ImageEntryPoint.class, null);
	}
}
