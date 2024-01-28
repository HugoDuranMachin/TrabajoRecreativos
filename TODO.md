The menus are coded in the following way:

All menus are looping
This means the menu calls itself at the end of the function.
When anything that isn't 1-9 (hereby 0) is pressed, the function 
    returns early, without reaching the loop.

Every submenu will work equally, so that pressing 0 will act 
    equal to "going back" one layer. This has the added benefit
    of being able to call any menu from any other without having
    to keep track of which menu was open last.

If a menu is required to early return (an object deletes itself)
    another early return will be called

