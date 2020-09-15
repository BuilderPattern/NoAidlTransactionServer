package com.sinitek.transactionservernoaidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

public class NoAidlService extends Service {
    private static final String INTERFACETOKEN = "NoAidlService";

    public IBinder onBind(Intent t) {
        return mBinder;
    }

    private NormalBinder mBinder = new NormalBinder();

    private class NormalBinder extends Binder {
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {//0加，1乘
            switch (code) {
                case 0: {
                    data.enforceInterface(INTERFACETOKEN);//检测标识
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    int _result = _arg0 + _arg1;
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case 1: {
                    data.enforceInterface(INTERFACETOKEN);
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    int _result = _arg0 * _arg1;
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
    }
}