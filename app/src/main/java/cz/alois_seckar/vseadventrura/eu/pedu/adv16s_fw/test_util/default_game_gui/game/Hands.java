/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IBagG;



/*******************************************************************************
 * {@code Hands} instances represents the repository,
 * to which the players store the items picked up in individual spaces,
 * so that they could be moved to other spaces and/or used.
 * The disposal site has a final capacity defining the maximal permitted
 * sum of weights of items occuring in the repository.
 * * <p>
 * In this game the disposal site are the player hands with capacity 2.
 * The item weight represents the number of hands needed for its taking.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class Hands extends AItemContainer implements IBagG
{
//== CONSTANT CLASS FIELDS =====================================================

    /** Capacity of the bag. */
    static final int CAPACITY = 2;

    /** The only instance of the bag in the game. */
    private static final Hands SINGLETON = new Hands();



//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================

    /** Free capacity of the bag. */
    private int remains;



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Factory method returning the only existing instance of the game.
     *
     * @return The instance of the given game
     */
    static Hands getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     */
    Hands()
    {
        super("Bag-Hands");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the bag capacity, i.e. the maximal permitted sum
     * of weights of items, that can be put into the bag at the same time.
     *
     * @return Capacity of the bag
     */
    @Override
    public int getCapacity()
    {
        return CAPACITY;
    }


    /***************************************************************************
     * Returns information if the bag is full,
     * or if some item can be still put in.
     *
     * @return {@code true} if it is full, {@code false} otherwise
     */
    boolean isFull()
    {
        return remains == 0;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * The method initializing the bag.
     * As the player of this game has an empty bag at the game beginning,
     * this method can only clean the {@link #items} collection.
     */
    void initialize()
    {
        initializeItems();
        remains = CAPACITY;
    }


    /***************************************************************************
     * Removes the given item from the bag
     * and increases the free capacity of the bag.
     *
     * @param item Item taken away
     */
    @Override
    void removeItem(Item item)
    {
        super.removeItem(item);
        remains += item.getWeight();
    }


    /***************************************************************************
     * If the given item fits to the bag, it adds it;
     * after that it returns the message on the result.
     *
     * @param item The item that has to be added into the bag
     * @return The message on the result: {@code true} = was added,
     *         {@code false} = was not added
     */
    boolean tryAddItem(Item item)
    {
        if (item.getWeight() > remains) {
            return false;
        }
        addItem(item);
        remains -= item.getWeight();
        return true;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
