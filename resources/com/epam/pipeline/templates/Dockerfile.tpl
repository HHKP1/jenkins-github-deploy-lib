FROM node:${NODE_VERSION}
WORKDIR /opt
ADD . /opt
RUN npm install
EXPOSE ${CONTAINER_PORT}
ENTRYPOINT npm run start