/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IWorldG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.INamed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import com.annimon.stream.Optional;
import com.annimon.stream.Stream;

import static cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game.Item.*;
import static cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game.Texts.*;



/*******************************************************************************
 * {@code Apartment} instance represents the game world.
 * It is responsible for arrangement of individual spaces and keeps information,
 * in which space the player is just situated.
 * <p>
 * In this game the world is an apartment and its rooms are individual spaces.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class Apartment implements IWorldG
{
//== CONSTANT CLASS FIELDS =====================================================

    /** The only instance (singleton) of this world (apartment). */
    private static final Apartment SINGLETON = new Apartment();



//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================

    /** The collection of all spaces (mostly rooms) in this world. */
    private final Collection<Room> rooms;

    /** The immutable collection of all spaces (mostly rooms) in this world
     *  that continuously maps the {@link #rooms} collection content. */
    private final Collection<Room> exportedRooms;

    /** Room in which the game begins. */
    private final Room startingRoom;



//== VARIABLE INSTANCE FIELDS ==================================================

    /** The space, in which the player is just situated */
    private Room currentSpace;


//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * The factory method returning the only existing instance of the game.
     *
     * @return The only instance of the given game
     */
    static Apartment getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * The private constructor creating the only instance of the space world.
     * Within this manager definition it creates all game spaces.
     */
    private Apartment()
    {
        rooms         = new ArrayList<>();
        exportedRooms = Collections.unmodifiableCollection(rooms);
        startingRoom  = new Room(HALL,
                            new String[] {BEDROOM, LIVING_ROOM, BATHROOM},
                            STANDARD+SHOE_RACK, STANDARD+UMBRELLA);
        rooms.add(startingRoom);
        rooms.add(new Room(BEDROOM,
                           new String[] {HALL},
                           NOT_MOVABLE+BED, NOT_MOVABLE+MIRROR,
                           STANDARD+BATHROBE));
        rooms.add(new Room(LIVING_ROOM,
                           new String[] {HALL, KITCHEN},
                           DOUBLE_HAND+TV));
        rooms.add(new Room(BATHROOM,
                           new String[] {HALL},
                           STANDARD+GLASSES, STANDARD+MAGAZINE,
                           NOT_MOVABLE+SINK));
        rooms.add(new Room(KITCHEN,
                           new String[] {LIVING_ROOM, BEDROOM},
                           DOUBLE_HAND+ICE_BOX ,STANDARD+PAPER));
        rooms.add(new Room(ICE_BOX,
                           new String[] {},
                           ALCOHOL+BEER, ALCOHOL+BEER, ALCOHOL+BEER,
                           STANDARD+SALAMI, STANDARD+BUN,
                           ALCOHOL+WINE, ALCOHOL+RUM));
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the collection of all spaces of the game.
     *
     * @return Collection of all spaces performing in the game
     */
    @Override
    public Collection<Room> getAllSpaces()
    {
        return exportedRooms;
    }


    /***************************************************************************
     * Returns the current space,
     * i.e. to the space in which the player is just situated.
     *
     * @return The space in which the player is just situated
     */
    @Override
    public Room getCurrentSpace()
    {
        return currentSpace;
    }


    /***************************************************************************
     * Sets the given space as the current one,
     * i.e. the space, in which the player is just situated.
     *
     * @param destinationRoom The set space
     */
    void setCurrentSpace(Room destinationRoom)
    {
        currentSpace = destinationRoom;
    }


    /***************************************************************************
     * Returns the space (room) with the given name
     * wrapped in the {@link Optional}.
     *
     * @param name Name of the required space
     * @return The wrapped space with the given name
     */
    public Optional<Room> getORoom(String name)
    {
        Optional<Room> result = INamed.getO(name, rooms);
        return result;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * The method initializing the game world.
     * Firstly it initializes all spaces
     * and then it sets the initial current space.
     */
    void initialize()
    {
        for (Room current : rooms) { current.initialize(); }
        currentSpace = startingRoom;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
