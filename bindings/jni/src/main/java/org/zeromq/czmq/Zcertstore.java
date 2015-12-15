/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Please refer to the README for information about making permanent changes.  #
################################################################################
*/
package org.zeromq.czmq;

public class Zcertstore implements AutoCloseable{
    static {
        try {
            System.loadLibrary ("czmqjni");
        }
        catch (Exception e) {
            System.exit (-1);
        }
    }
    public long self;
    /*
    Create a new certificate store from a disk directory, loading and        
    indexing all certificates in that location. The directory itself may be  
    absent, and created later, or modified at any time. The certificate store
    is automatically refreshed on any zcertstore_lookup() call. If the       
    location is specified as NULL, creates a pure-memory store, which you    
    can work with by inserting certificates at runtime.                      
    */
    native static long __new (String location);
    public Zcertstore (String location) {
        /*  TODO: if __new fails, self is null...            */
        self = __new (location);
    }
    public Zcertstore (long pointer) {
        self = pointer;
    }
    /*
    Destroy a certificate store object in memory. Does not affect anything
    stored on disk.                                                       
    */
    native static void __destroy (long self);
    @Override
    public void close () {
        __destroy (self);
        self = 0;
    }
    /*
    Look up certificate by public key, returns zcert_t object if found,
    else returns NULL. The public key is provided in Z85 text format.  
    */
    native static long __lookup (long self, String publicKey);
    public Zcert lookup (String publicKey) {
        return new Zcert (__lookup (self, publicKey));
    }
    /*
    Insert certificate into certificate store in memory. Note that this
    does not save the certificate to disk. To do that, use zcert_save()
    directly on the certificate. Takes ownership of zcert_t object.    
    */
    native static void __insert (long self, long certP);
    public void insert (Zcert certP) {
        __insert (self, certP.self);
    }
    /*
    Print list of certificates in store to logging facility
    */
    native static void __print (long self);
    public void print () {
        __print (self);
    }
    /*
    Self test of this class
    */
    native static void __test (boolean verbose);
    public static void test (boolean verbose) {
        __test (verbose);
    }
}