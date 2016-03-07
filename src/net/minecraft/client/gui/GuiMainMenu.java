//find
this.buttonList.add(new GuiButtonLanguage(5, this.width / 2 - 124, j + 72 + 12));
//and below that add this
this.buttonList.add(new Guinick2(99, this.width / 2 - 150, j + 72 + 12));
//then find this
if (button.id == 12)
{
    ISaveFormat isaveformat = this.mc.getSaveLoader();
    WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

    if (worldinfo != null)
    {
       this.mc.displayGuiScreen(new GuiYesNo(this, I18n.format("selectWorld.deleteQuestion", new Object[0]), "\'" + worldinfo.getWorldName() + "\' " + I18n.format("selectWorld.deleteWarning", new Object[0]), I18n.format("selectWorld.deleteButton", new Object[0]), I18n.format("gui.cancel", new Object[0]), 12));
    }
}
//and below that add this
if (button.id == 99)
{
	this.mc.displayGuiScreen(new Guinick(this));
}