FROM node:lts-alpine3.14

WORKDIR /individual_track_react

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 3000

CMD [ "npm" , "start" ]
 