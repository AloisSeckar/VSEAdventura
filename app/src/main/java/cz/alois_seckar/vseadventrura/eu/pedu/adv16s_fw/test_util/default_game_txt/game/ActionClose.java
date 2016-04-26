/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game;



/*******************************************************************************
 * {@code ActionOpen} instances process the commands
 * which have to close certain item.
 * In this game the item is always the ice-box in kitchen,
 * but generally the game can be extended to opening other items
 * in other spaces.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class ActionClose extends AAction
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
     * closing the item that is the current space.
     * After this closing, the space in which the closed item is placed
     * becomes the current space.
     */
    ActionClose()
    {
        super (Texts.aCLOSE,
        "It verifies if the player really wants to close ice-box,\n"
      + "given as the command argument.\n"
      + "If it is so, it is closed and the player moves to kitchen.\n"
      + "Otherwise nothing will be done "
      + "and the error message will be reported.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Closes the given item and moves the player to the space,
     * in which the closed item is located.
     * But before that it checks,
     * <ul>
     * <li>if the item that should be opened is given,</li>
     * <li>if this item is the ice-box,</li>
     * <li>if the ice-box is a current space.</li>
     * </ul>
     *
     * @param arguments The only allowed argument is up-to-now the ice-box
     * @return The message text written after accomplishing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts.mNO_CLOSE;
        }
        String      roomName = arguments[1];
        Apartment  apartment = Apartment.getInstance();
        Room     currentRoom = apartment.getCurrentSpace();
        if (! currentRoom.getName().equalsIgnoreCase(roomName)) {
            return Texts.mNOT_CURRENT_SPACE;
        }
        if (! roomName.equalsIgnoreCase(Texts.ICE_BOX)) {
            return Texts.mONLY_ICEBOX;
        }
        Room newCurrent = apartment.getORoom(Texts.KITCHEN).get();
        Apartment.getInstance().setCurrentSpace(newCurrent);
        return Texts.mICEBOX_CLOSED;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
