package Draw_Map;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonCreate {
	private JFrame f;
	public ButtonCreate(JFrame f)
	{
		this.f = f;
	}
	public void addButton()
	{   
		JButton button = new JButton("1");
		button.setBounds(1140, 40, 60, 30);
        Container content = f.getContentPane();
        content.setLayout(null);
        content.add(button);	
//        button.addActionListener(new ActionListener(
//        		{
//
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// TODO Auto-generated method stub
//						RemoteControl rc = new RemoteControl();
//						
//					}
//
//        		}
//        		);
	}

}
