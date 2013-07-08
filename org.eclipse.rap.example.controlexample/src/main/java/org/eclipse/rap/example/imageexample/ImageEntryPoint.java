package org.eclipse.rap.example.imageexample;



import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


public class ImageEntryPoint extends AbstractEntryPoint {

    @Override
    protected void createContents(Composite parent) {
    	Image image = new Image(parent.getDisplay(), ImageEntryPoint.class.getResourceAsStream("image.png"));
    	Button button = new Button(parent, SWT.PUSH);
    	button.setImage(image);
    }
    
}
