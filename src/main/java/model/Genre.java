package model;

/**
 * An enumerated type whose elements represent possible genres of music. This data will become useful when the user
 * wants to filter the available music by genre.
 *
 * @author Andrew Groebe.
 */
public enum Genre {
    POP,
    ROCK,
    JAZZ,
    FOLK,
    BLUES,
    COUNTRY,
    HIP_HOP,
    RAP,
    METAL;

    @Override
    public String toString() {
        return name();
    }
}
