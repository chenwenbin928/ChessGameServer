package info.xiaomo.server;

import info.xiaomo.gameCore.protocol.NetworkConsumer;
import info.xiaomo.gameCore.protocol.client.Client;
import info.xiaomo.gameCore.protocol.client.ClientBuilder;
import info.xiaomo.gameCore.protocol.message.AbstractMessage;
import info.xiaomo.server.back.BackMessagePool;
import info.xiaomo.server.server.ServerOption;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StopServerClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(StopServerClient.class);

    public static void main(String[] args) throws Exception {

        try {
            String optionPath = args[0];

            ServerOption option = new ServerOption(optionPath);
            ClientBuilder builder = new ClientBuilder();
            builder.setHost("localhost");//只关本机的服务器
            builder.setPort(option.getBackServerPort());
            builder.setConsumer(new Consumer());
            builder.setMsgPool(new BackMessagePool());

            Client client = builder.createClient();
            client.connect(false);

//            ReqCloseServerMessage.Builder newBuilder = ReqCloseServerMessage.newBuilder();
//            newBuilder.setCommand("1");
//            ReqCloseServerMessage msg = newBuilder.build();
//            client.sendMsg();

            int count = 10;
            while (count > 0) {
                Thread.sleep(10 * 1000);
                count--;
            }
        } catch (Exception e) {
            LOGGER.error("关服发生错误", e);
        }

        System.exit(0);

    }


    static class Consumer implements NetworkConsumer {

        @Override
        public void consume(AbstractMessage message, Channel channel) {

        }

        @Override
        public void connected(Channel channel) {

        }

        @Override
        public void disconnected(Channel channel) {

        }

        @Override
        public void exceptionOccurred(Channel channel, Throwable error) {

        }
    }


}
