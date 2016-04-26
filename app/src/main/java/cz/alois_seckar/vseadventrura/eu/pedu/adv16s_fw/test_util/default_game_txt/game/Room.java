/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.INamed;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.ISpace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import com.annimon.stream.Optional;
import com.annimon.stream.Stream;


/*******************************************************************************
 * {@code Room} instances represent the spaces in the game.
 * <p>
 * The apartment rooms (and the ice-box) are spaces in this program.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class Room extends AItemContainer implements ISpace
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

    /** Names of neighbors of the given space at the game beginning. */
    private final String[] neighborNames;

    /** Current neighbors of the given space. */
    private final Collection<Room> neighbors;

    /** Immutable collection of current neighbors of the given space,
     *  that continuously maps the {@link #neighbors} collection content. */
    private final Collection<Room> exportedNeighbors;



//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Creates a new space with the given name and
     * with the given names of its initial neighbors and items.
     *
     * @param name          Name of the given space
     * @param neighborNames Names of space neighbors at the game beginning
     * @param itemNames     Names of items in the space at the game beginning
     */
    Room(String name, String[] neighborNames, String... itemNames)
    {
        super(name, itemNames);
        this.neighborNames    = neighborNames;
        this.neighbors        = new ArrayList<>();
        this.exportedNeighbors= Collections.unmodifiableCollection(neighbors);
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the collection of current neighbors of this space, i.e. the
     * collection of spaces, to which we can move from this space with the
     * command of the {@link cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.TypeOfStep#tsMOVE
     * TypeOfStep.tsMOVE} type.
     *
     * @return Collection of neighbors
     */
    @Override
    public Collection<Room> getNeighbors()
    {
        return exportedNeighbors;
    }


    /***************************************************************************
     * Vrátí pozici místnosti na plánu hry,
     * přesněji pozici hráče nacházejícího se v dané místnosti.
     * Na této pozici bude hráč při pobytu v dané místnosti zobrazen.
     *
     * @return Požadovaná pozice

    @Override
    public Point getPosition()
    {
        //TODO Room.getPosition - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }*/



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Method initializing the given space.
     * Based on the names remembered by the constructor
     * it initializes the neighbors of the given space and its items.
     */
    void initialize()
    {
        initializeItems();
        initializeNeighbors();
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /***************************************************************************
     * Cleans the collection {@link #neighbors} and saves into it the items representing
     * the spaces neighboring with the given space at the game beginning.
     */
    private void initializeNeighbors()
    {
        Apartment apartment = Apartment.getInstance();
        neighbors.clear();
        Stream.of(neighborNames)
              .map(apartment::getORoom)
              .map(Optional<Room>::get)
              .forEach(neighbors::add);
    }

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
