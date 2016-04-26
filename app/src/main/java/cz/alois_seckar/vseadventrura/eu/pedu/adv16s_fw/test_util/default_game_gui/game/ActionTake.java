/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game;

import com.annimon.stream.Optional;



/*******************************************************************************
 * {@code ActionTake} instances process the commands
 * that take away items from the current space and put them to the bag.
 * </p>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class ActionTake extends AAction
{
//== CONSTANT CLASS FIELDS =====================================================
//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Creates an action instance for
     * taking an item away from the current space and putting it into the bag.
     */
    ActionTake()
    {
        super (Texts.aTAKE,
        "It moves the given item from the current space to the bag.\n"
      + "It moves only items that can be picked up.\n"
      + "Otherwise nothing will be done "
      + "and the error message will be reported.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Removes the item given in an argumenant from the current space (room)
     * and puts it into the bag.
     * But it requires so that the item with the given name<br>
     * a) would be located in the current space,<br>
     * b) could be picked up and<br>
     * c) would fit into the bag.<br>
     * Otherwise nothing will be done and the command is reported as wrong.
     *
     * @param arguments Parameters of the command
     * @return The message text written after accomplishing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts.mNO_TAKE_ITEM;
        }
        String itemName      = arguments[1];
        Room   currentRoom   = Apartment.getInstance().getCurrentSpace();
        Optional<Item> oItem = currentRoom.getOItem(itemName);
        if (! oItem.isPresent()) {
            return Texts.mNOT_HERE + itemName;
        }
        Item item = oItem.get();
        Hands bag = Hands.getInstance();
        if (item.getWeight() >= bag.getCapacity()) {
            return Texts.mHEAVY_ITEM + itemName;
        }
        boolean added = bag.tryAddItem(item);
        if (added) {
            if (currentRoom.equals(Apartment.getInstance()
                                            .getORoom(Texts.ICE_BOX)
                                            .get()) &&
                item.isAlcoholic()  &&  ! State.isMajor())
            {
                bag.removeItem(item);
                return Conversation.start(item);
            }
            currentRoom.removeItem(item);
            return Texts.mTAKEN + itemName;
        }
        else {
            return Texts.mBAG_FULL;
        }
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
