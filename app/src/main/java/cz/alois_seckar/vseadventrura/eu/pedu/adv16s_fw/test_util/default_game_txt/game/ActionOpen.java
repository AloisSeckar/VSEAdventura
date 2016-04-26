/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game;

import com.annimon.stream.Optional;



/*******************************************************************************
 * {@code ActionOpen} instances process the commands
 * that have to open certain item.
 * In this game the item is always the ice-box in the kitchen,
 * but generally the game can be extended by opening other items
 * in other spaces.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class ActionOpen extends AAction
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
     * opening the item that can be opened
     * (after checking the defined conditions)
     * and after opening it becomes a current space.
     */
    ActionOpen()
    {
        super (Texts.aOPEN,
        "It verifies that the player really wants to open the open-able item,\n"
      + "given as an argument of the command.\n"
      + "If it opens the ice-box, it checks if it is supported.\n"
      + "If all conditions are fulfilled, "
      + "the player moves into the given item.\n"
      + "Otherwise nothing will be done "
      + "and the error message will be reported.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Opens the given item and moves the player into it as into a new space.
     * But before that it checks,
     * <ul>
     * <li>if the item that has to be open is given,</li>
     * <li>if this item is in the current space,</li>
     * <li>if this item can be opened, i.e. if it is also the space,</li>
     * <li>if the ice-box has been already supported to be open.</li>
     * </ul>
     *
     * @param //parameters The only allowed argument is up-to-now the ice-box
     * @return The message text written after accomplishing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts.mNO_OPENING;
        }
        String      itemName = arguments[1];
        Apartment  apartment = Apartment.getInstance();
        Room     currentRoom = apartment.getCurrentSpace();
        Optional<Item> oItem = currentRoom.getOItem(itemName);
        if (! oItem.isPresent()) {
            return Texts.mNOT_HERE;
        }
        Optional<Room> oDestinationRoom = apartment.getORoom(itemName);
        if (! oDestinationRoom.isPresent()) {
            return Texts.mNOT_OPENABLE;
        }
        if (! State.isIceboxUnderlaid()) {
            return Texts.mICEBOX_CANNOT_BE_OPENED;
        }
        apartment.setCurrentSpace(oDestinationRoom.get());
        return Texts.mICEBOX_OPENED;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
