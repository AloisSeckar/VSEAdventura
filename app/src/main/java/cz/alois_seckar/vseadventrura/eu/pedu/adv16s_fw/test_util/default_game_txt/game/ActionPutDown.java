/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game;

import com.annimon.stream.Optional;



/*******************************************************************************
 * {@code ActionPickUp} instances process the commands
 * that take away items from the current space and puts them into the bag.
 * </p>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class ActionPutDown extends AAction
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
     * Creates an action instance for taking
     * the item away from the bag and putting it into the current space.
     */
    ActionPutDown()
    {
        super (Texts.aPUT_DOWN,
        "It moves the given item from the bag into the current space.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Removes the item given in an argumenant from the bag
     * and puts it into the current space (room).
     * But it requires that the given named item would be located in the bag.
     * Otherwise nothing will be done and the command is reported as wrong.
     *
     * @param arguments Parameters of the command
     * @return The message text written after accomplishing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts.mNO_PUT_ITEM;
        }
        String      itemName = arguments[1];
        Hands            bag = Hands.getInstance();
        Optional<Item> oItem = bag.getOItem(itemName);
        if (! oItem.isPresent()) {
            return Texts.mNOT_IN_BAG + itemName;
        }
        Item item = oItem.get();
        bag.removeItem(item);
        Room  currentRoom   = Apartment.getInstance().getCurrentSpace();
        currentRoom.addItem(item);
        return Texts.mPUT_DOWN + item.getName();
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
