//find
this.buttonList.add(new GuiButton(0, this.width / 2 + 4 + 76, this.height - 28, 75, 20, I18n.format("gui.cancel")));
//and below that add this
this.buttonList.add(new UserNameBtn(99, this.width / 2 - 185, this.height - 52));
//then find this
else if (button.id == 8)
            {
                this.refreshServerList();
            }
//and below that add this
else if (button.id == 99)
            {
            	this.mc.displayGuiScreen(new UserNameGui(this));
            }