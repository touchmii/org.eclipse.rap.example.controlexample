package org.eclipse.rap.example.imageexample;



import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;


public class ImageEntryPoint extends AbstractEntryPoint {
	
	  protected Shell createShell( Display display ) {
		    Shell shell = new Shell( display, SWT.RESIZE );
		  //  shell.setMaximized( true );
		    return shell;
		  }

	  private void createTable(Composite shell) {
	  
	  final Table table = new Table (shell, SWT.BORDER | SWT.V_SCROLL);
		table.setHeaderVisible (true);
		table.setLinesVisible (true);
		final int rowCount = 64, columnCount = 4;
		for (int i=0; i < columnCount; i++) {
			TableColumn column = new TableColumn (table, SWT.NONE);
			column.setText ("Column " + i);
		}
		for (int i=0; i < rowCount; i++) {
			TableItem item = new TableItem (table, SWT.NONE);
			for (int j=0; j < columnCount; j++) {
				item.setText (j, "Itemg " + i + "-" + j);
			}
		}
		for (int i=0; i < columnCount; i++) {
			table.getColumn (i).pack ();
		}
		Rectangle clientArea = shell.getClientArea ();
		table.setLocation (clientArea.x, clientArea.y);
		Point size = table.computeSize (SWT.DEFAULT, 200);
		table.setLayoutData(new GridData(SWT.DEFAULT, 400));
		shell.pack ();
		table.addListener (SWT.MouseDown, new Listener () {
			public void handleEvent (Event event) {
				Rectangle clientArea = table.getClientArea ();
				Point pt = new Point (event.x, event.y);
				int index = table.getTopIndex ();
				while (index < table.getItemCount ()) {
					boolean visible = false;
					TableItem item = table.getItem (index);
					for (int i=0; i < columnCount; i++) {
						Rectangle rect = item.getBounds (i);
						if (rect.contains (pt)) {
							System.out.println ("Item " + index + "-" + i);
						}
						if (!visible && rect.intersects (clientArea)) {
							visible = true;
						}
					}
					if (!visible) return;
					index++;
				}
			}
		});
		
	  }

	@Override
    protected void createContents(final Composite parent) {
		
		/*
		parent.setLayout(new FillLayout());
		
		Group group = new Group(parent, SWT.NONE);
		group.setText("Title");
		group.setLayout(new FillLayout());
		
		
		final Button b = new Button(group, SWT.PUSH);
		b.setText("Button");
		b.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(b.getBounds());
			}
		});
		*/
		
	
		parent.setLayout(new GridLayout(2, false));
		Button button = new Button(parent, SWT.PUSH);
		button.setText("leftg");
		
		button.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true));
		createTable(parent);
		
		
    	Image image = new Image(parent.getDisplay(), ImageEntryPoint.class.getResourceAsStream("image.png"));
    	ImageData scaledTo = image.getImageData().scaledTo(50, 100);
    	Image scaledImage = new Image(parent.getDisplay(), scaledTo);
//		parent.addControlListener(new ControlAdapter() {
//			@Override
//			public void controlResized(ControlEvent e) {
//				System.out.println(parent.getBounds());
//				System.out.println("resized");
//			}
//		});
//		
//		parent.addControlListener(new ControlAdapter() {
//			
//			@Override
//			public void controlMoved(ControlEvent e) {
//				System.out.println(parent.getLocation());
//				System.out.println("moved");
//			}
//		});
    	
//    	GridLayout layout = new GridLayout();
//    	layout.horizontalSpacing = 0;
//    	layout.verticalSpacing = 0;
//    	layout.marginBottom = 0;
//    	layout.marginLeft = 0;
//    	layout.marginRight = 0;
//    	layout.marginTop = 0;
//    	layout.marginWidth = 0;
//    	layout.marginHeight = 0;
//    	parent.setLayout(layout);
//    	
//    	GridData gridData = new GridData();
//    	gridData.minimumWidth = 0;
//    	gridData.minimumHeight = 0;
//    	gridData.grabExcessHorizontalSpace = true;
//    	gridData.grabExcessVerticalSpace = true;
//    	gridData.verticalAlignment = GridData.FILL;
//    	gridData.horizontalAlignment = GridData.FILL;
    	
//    	final Button button = new Button(parent, SWT.NONE);
//    	button.setText("button");
//    	GridData gridData = new GridData();
//    	gridData.minimumWidth = 0;
//    	gridData.minimumHeight = 0;
//    	gridData.grabExcessHorizontalSpace = true;
//    	gridData.grabExcessVerticalSpace = true;
//    	gridData.verticalAlignment = GridData.FILL;
//    	gridData.horizontalAlignment = GridData.FILL;
//    			
//    	button.setLayoutData(gridData);
//       	button.addSelectionListener(new SelectionAdapter() {
//    		@Override
//    		public void widgetSelected(SelectionEvent arg0) {
//    			System.out.println("size: " + button.getBounds());
//    		}
//		});
//    	
//       	Label label = new Label(parent, SWT.NONE);
//       	label.setText("llllO");
//       	new Label(parent, SWT.NONE).setText("HllOO");
//       	new Label(parent, SWT.NONE).setText("HELLO");
//       	new Label(parent, SWT.NONE).setText("HELLO, WORLD! HOW ARE you? O");
//       	new Button(parent, SWT.NONE).setText("HELLO, WORLD! HOW ARE you? O");

       	
//       	Group group = new Group (parent, SWT.NONE);
//       	group.setLayoutData(gridData);
//       	FillLayout fillLayout = new FillLayout ();
//       	fillLayout.marginHeight = 0;
//       	fillLayout.marginWidth = 0;
//    	group.setLayout (fillLayout);
//    	group.setText ("a square");
//    	new Button(group, SWT.PUSH).setText("Button In Group");
//    	Canvas canvas = new Canvas (group, SWT.NONE);
//    	canvas.addPaintListener (new PaintListener () {
//    		public void paintControl (PaintEvent e) {
//    			//e.gc.drawImage (image, 0, 0);
//    		}
//    	});

    	
    	Button b2 = new Button(parent, SWT.PUSH);
    	b2.setImage(scaledImage);
    	
    	//new Label(parent, SWT.NONE).setText("Button Again");
    	//Button button2 = new Button(parent, SWT.PUSH);
    	//button2.setImage(scaledImage);
    	
    	//new Label(parent, SWT.NONE).setText("Label");
    	//Label label = new Label(parent, SWT.NONE);
    	//label.setImage(image);
    	
    }
    
}
