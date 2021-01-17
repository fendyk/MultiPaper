package puregero.multipaper.server.handlers;

import puregero.multipaper.server.DataOutputSender;
import puregero.multipaper.server.ServerConnection;
import puregero.multipaper.server.locks.ChunkLock;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ReleaseChunkHandler implements Handler {
    @Override
    public void handle(ServerConnection connection, DataInputStream in, DataOutputSender out) throws IOException {
        String world = in.readUTF();
        int cx = in.readInt();
        int cz = in.readInt();

        ChunkLock.release(connection.getBungeeCordName(), world, cx, cz);
    }
}
