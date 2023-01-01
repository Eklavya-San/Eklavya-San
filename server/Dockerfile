FROM    node
WORKDIR /app
COPY    package.json /app
RUN node install
COPY    . /app
CMD node server.js
EXPOSE 4949