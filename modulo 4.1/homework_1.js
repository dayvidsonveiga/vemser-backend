
db.comentario.insertMany(
    [
        {
            "idComentario":1,
            "idPostagem":2,
            "idUsuario":2,
            "descricaoComentarios":"Oportunidade de trabalho remoto",
            "curtidasComentario":10,
            "dataComentario": new Date.now()
        },
        {
           "idComentario":2,
            "idPostagem":3,
            "idUsuario":3,
            "descricaoComentarios":"Oportunidade de trabalho presencial",
            "curtidasComentario":5,
            "dataComentario": new Date.now()
        }])

db.postagem.find({})

db.postagem.find({}).pretty()

db.postagem.find({
    "descricaoComentarios":"Oportunidade de trabalho remoto"
}).pretty()