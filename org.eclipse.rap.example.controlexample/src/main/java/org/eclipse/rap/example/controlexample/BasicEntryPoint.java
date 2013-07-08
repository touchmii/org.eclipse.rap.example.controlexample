package org.eclipse.rap.example.controlexample;


import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.swt.widgets.Composite;


public class BasicEntryPoint extends AbstractEntryPoint {

    @Override
    protected void createContents(Composite parent) {
    	new ControlExample(parent);
    }
    
}
