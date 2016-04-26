/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt;

import java.util.Collection;
import com.annimon.stream.Optional;
import com.annimon.stream.Stream;



/*******************************************************************************
 * Instances of the {@code ANamed} interface are named objects,
 * i.e. objects having their name.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface INamed
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================

    /***************************************************************************
     * Seeks an object with given name in the array and returns it wrapped
     * into the object of {@link Optional}{@code <}{@link INamed}{@code >} type.
     * If there are more objects with this name, it returns the first found.
     * If it does not find any, it returns empty object (<b>NOT empty reference</b>!).
     *
     * @param <E>    Type of elements of searched array
     * @param member Name of searched object
     * @param array  Searched array
     * @return Found object wrapped into the object of
     *         {@link Optional}{@code <}{@link INamed}{@code >} type
     */
    public static <E extends INamed> Optional<E>
           getO(String member, E[] array)
    {
        Optional<E> result = getO(member, Stream.of(array));
        return result;
    }


    /***************************************************************************
     * Seeks an object with given name in the collection and returns it wrapped
     * into the object of {@link Optional}{@code <}{@link INamed}{@code >} type.
     * If there are more objects with this name, it returns the first found.
     * If it does not find any, it returns empty object
     * (<b>NOT empty reference</b>!).
     *
     * @param <E>        Type of elements of searched collection
     * @param member     Name of searched object
     * @param collection Searched collection
     * @return Found object wrapped into the object of
     *         {@link Optional}{@code <}{@link INamed}{@code >} type
     */
    public static <E extends INamed> Optional<E>
           getO(String member, Collection<E> collection)
    {
        Optional<E> result = getO(member, Stream.of(collection));
        return result;
    }


    /***************************************************************************
     * Seeks an object with given name in the stream and returns it wrapped
     * into the object of {@link Optional}{@code <}{@link INamed}{@code >} type.
     * If there are more objects with this name, it returns the first found.
     * If it does not find any, it returns empty object
     * (<b>NOT empty reference</b>!).
     *
     * @param <E>    Type of elements of searched collection
     * @param member Name of searched object
     * @param stream Searched stream
     * @return Found object wrapped into the object of
     *         {@link Optional}{@code <}{@link INamed}{@code >}type
     */
    public static <E extends INamed> Optional<E>
           getO(String member, Stream<E> stream)
    {
        Optional<E> result =
            stream.filter(iNamed -> iNamed.getName().equalsIgnoreCase(member))
                  .findFirst();
        return result;
    }



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the name of the instance.
     *
     * @return Name of the instance
     */
//    @Override
    public String getName()
    ;



//== OTHER ABSTRACT METHODS ====================================================
//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================

    /***************************************************************************
     * Returns the textual signature of this instance
     * composed from its mother class name followed by
     * an underline sign and the name of the instance.
     *
     * @return Textual signature
     */
    default public String toStringWithClass()
    {
        return getClass().getSimpleName() + "_" + getName();
    }



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
