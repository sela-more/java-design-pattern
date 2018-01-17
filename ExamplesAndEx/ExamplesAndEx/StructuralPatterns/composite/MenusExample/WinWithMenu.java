package composite.MenusExample;
import java.awt.*;

class WinWithMenu {
   public static void main(String args[]) {
      Frame f = new Frame();
      MenuBar mb = new MenuBar();
      Menu fileMenu = new Menu("File");
      Menu editMenu = new Menu("Edit");
      Menu subMenu = new Menu("Last Files");
      MenuItem newMItem = new MenuItem("New");
      MenuItem gif1MItem = new MenuItem("Rose.gif");
      MenuItem gif2MItem = new MenuItem("Lion.gif");
      CheckboxMenuItem cbmi = new CheckboxMenuItem("Read Only");

		// put menu-items into sub-menu
      subMenu.add(gif1MItem);
      subMenu.add(gif2MItem);

		// put menu-items into menu
		fileMenu.add(newMItem);
      fileMenu.add(subMenu);
      fileMenu.add(cbmi);

		// put menus into menubar
      mb.add(fileMenu);
      mb.add(editMenu);

		// attach menubar to frame
		f.setMenuBar(mb);

      f.setSize(200, 200);
      f.setVisible(true);
   }
}
